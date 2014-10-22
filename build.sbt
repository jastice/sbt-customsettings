organization := "sbt"

name := "sbt-customsettings"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"

sbtPlugin := true

// plugins that sbt-clueda provides
addSbtPlugin("no.arktekk.sbt" % "aether-deploy" % "0.13")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.6.0")
