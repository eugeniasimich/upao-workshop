name := """bonzzu-workshop"""

version := "1.4"

scalaVersion := "2.12.4"

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  guice,
  filters,
  "com.adrianhurt" %% "play-bootstrap" % "1.4-P26-B4-SNAPSHOT",
  "org.webjars" % "bootstrap" % "4.0.0-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "3.3.1-1",
  "org.webjars" % "font-awesome" % "4.7.0",
  "org.webjars" % "bootstrap-datepicker" % "1.4.0" exclude("org.webjars", "bootstrap"),
  "javax.xml.bind" % "jaxb-api" % "2.1",
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" ,
  "org.seleniumhq.selenium" % "selenium-java" % "2.41.0"
)


scalariformSettings

fork := true

javaOptions += "-Dwebdriver.chrome.driver=drivers/chromedriver.exe"

