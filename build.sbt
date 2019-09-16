name := "fp"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.softwaremill.quicklens" %% "quicklens" % "1.4.12",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
)

scalacOptions += "-deprecation"
