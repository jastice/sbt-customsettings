/*
 * Copyright (C) 2014 Clueda AG.
 * This work is proprietary and confidential. Any distribution,
 * reproduction, or modification is strictly prohibited under any
 * circumstances without the express prior written permission of Clueda
 * AG. All rights reserved.
 */
package sbt

import sbt._
import Keys._
import sbt.BuildLoader.BuildInfo
import org.scalastyle.sbt.ScalastylePlugin.scalastyleConfigUrl

/**
 *   The main entry point for Clueda Common Plugin.
 *    </ul>
 */
object SbtCustomsettings extends AutoPlugin {

  // reference documentation on plugins: http://www.scala-sbt.org/0.13/docs/Plugins.html

  override def trigger = allRequirements
  override def requires = empty

  object autoImport {
    val sbtCustomsettings = settingKey[Unit]("sbt-clueda plugin")
  }
  import autoImport._


  override lazy val projectSettings = Seq(

    // silly proof of existence
    sbtCustomsettings := println(s"sbt-customsettings active")
    ,
    // this setting is not seen by projects using this plugin
    scalastyleConfigUrl := Some(url("http://git.clueda-dev/meta/clueda_style/raw/master/clueda_scalastyle-config.xml"))
    ,
    // these settings are visible to projects
    publishMavenStyle := true
    ,
    publishTo <<= version { v: String =>
      val artifactory = "http://some.artifactory.server"
      if (v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at artifactory + "/libs-snapshot-local")
      else
        Some("releases" at artifactory + "/libs-release-local")
    }
  )

}