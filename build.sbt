name := """play-sandbox"""
organization := "com.extendedprism"
version := "1.0-SNAPSHOT"
scalaVersion := "2.12.0"

lazy val root =
  (project in file("."))
    .enablePlugins(PlayScala)
    .configs(IntegrationTest) // Adding the IntegrationTest Configuration
    .settings(inConfig(IntegrationTest)(Defaults.itSettings)) // Adding the IntegrationTest settings
    .settings(
      libraryDependencies ++= Seq(
        guice,
        "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % "test, it"
      ),
      scalaSource in IntegrationTest := baseDirectory.value / "it"
    )


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.extendedprism.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.extendedprism.binders._"
