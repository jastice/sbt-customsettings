# SBT lost custom settings error

Example project for stackoverflow issue: http://stackoverflow.com/questions/26490557/setting-a-third-party-plugin-setting-in-sbt-autoplugin

An AutoPlugin which aggregates several third-party plugins and customizes their settings for our company. For most of the plugins, this works just fine by putting them in the `projectSettings`:

    override lazy val projectSettings = Seq(publishMavenStyle := true)

I tried to do this for ScalaStyle as well:

    import org.scalastyle.sbt.ScalastylePlugin.scalastyleConfigUrl

    override lazy val projectSettings = Seq(
      scalastyleConfigUrl := Some(url("http://git.repo/scalastyle-config.xml"))
    )

This setting is never visible in projects using my plugin, instead sbt uses the plugin-provided default value:

    > inspect scalastyleConfigUrl
    [info] Setting: scala.Option[java.net.URL] = None
    [info] Description:
    [info]  Scalastyle configuration file as a URL
    [info] Provided by:
    [info]  {file:/Users/kaeser/Documents/workspace/ci-test-project/}root/*:scalastyleConfigUrl
    [info] Defined at:
    [info]  (org.scalastyle.sbt.ScalastylePlugin) Plugin.scala:101
    [info] Delegates:
    [info]  *:scalastyleConfigUrl
    [info]  {.}/*:scalastyleConfigUrl
    [info]  */*:scalastyleConfigUrl
    [info] Related:
    [info]  test:scalastyleConfigUrl

When I put the setting into build.sbt directly, it works as expected.
What might the issue be?

