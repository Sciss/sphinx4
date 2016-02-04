lazy val baseName  = "Sphinx4"

lazy val baseNameL = baseName.toLowerCase

lazy val commonJava = Seq("-encoding", "UTF8")

lazy val commonSettings = Seq(
  organization     := "de.sciss",        // originally: "edu.cmu.sphinx"
  version          := "1.0.0-SNAPSHOT",  // originally: "5prealpha-SNAPSHOT"
  javacOptions    ++= commonJava ++ Seq("-source", "1.6", "-target", "1.6"),
  javacOptions in (Compile, doc) := commonJava,
  crossPaths       := false,
  autoScalaLibrary := false
)

lazy val root = Project(id = baseNameL, base = file("."))
  .aggregate(core, data, samples)
  .dependsOn(core, data, samples)
  .settings(commonSettings)
  .settings(
    name              := baseName,
    packagedArtifacts := Map.empty
  )

lazy val core = Project(id = s"$baseNameL-core", base = file(s"$baseNameL-core"))
  .dependsOn(data)
  .settings(commonSettings)
  .settings(
    description := s"$baseName core",
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-math3"    % "3.2",
      "org.testng"         % "testng"           % "6.8.8" % "test",
      "org.hamcrest"       % "hamcrest-library" % "1.3"   % "test"
    )
  )

lazy val data = Project(id = s"$baseNameL-data", base = file(s"$baseNameL-data"))
  .settings(commonSettings)
  .settings(
    description := s"$baseName US English models"
  )

lazy val samples = Project(id = s"$baseNameL-samples", base = file(s"$baseNameL-samples"))
  .dependsOn(core, data)
  .settings(commonSettings)
  .settings(
    description := s"$baseName demo applications",
    mainClass in (Compile, run) := Some("edu.cmu.sphinx.demo.DemoRunner")
  )
