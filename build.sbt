name := """bonzzu-workshop"""

version := "1.4"

scalaVersion := "2.12.4"

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)


resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  guice,
  filters,
  "com.adrianhurt" %% "play-bootstrap" % "1.4-P26-B4-SNAPSHOT",
  "org.webjars" % "bootstrap" % "4.0.0-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "3.3.1-1",
  "org.webjars" % "font-awesome" % "4.7.0",
  "org.webjars" % "bootstrap-datepicker" % "1.4.0" exclude("org.webjars", "bootstrap"),
  "javax.xml.bind" % "jaxb-api" % "2.1"
)


scalariformSettings
