lazy val baseName  = "Sphinx4"

lazy val baseNameL = baseName.toLowerCase

lazy val commonJava = Seq("-encoding", "UTF8")

lazy val commonSettings = Seq(
  organization     := "de.sciss",        // originally: "edu.cmu.sphinx"
  version          := "1.0.0",           // originally: "5prealpha-SNAPSHOT"
  licenses         := Seq("BSD-style" -> url("https://raw.githubusercontent.com/Sciss/sphinx4/sbtfied/license.terms")),
  homepage         := Some(url("http://cmusphinx.sourceforge.net/")),
  javacOptions    ++= commonJava ++ Seq("-source", "1.6", "-target", "1.6"),
  javacOptions in (Compile, doc) := commonJava,
  // fork in test     := true,
  crossPaths       := false,
  autoScalaLibrary := false,
  scalaVersion     := "2.11.7", // not used
  // ---- publishing to Maven Central ----
  publishMavenStyle := true,
  publishTo := {
    Some(if (isSnapshot.value)
      "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    else
      "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
    )
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := {
    <scm>
      <url>git@github.com:Sciss/{baseNameL}.git</url>
      <connection>scm:git:git@github.com:Sciss/{baseNameL}.git</connection>
    </scm>
      <developers>
        <developer>
          <id>ppk96</id>
          <name>ppk96</name>
          <url>http://sourceforge.net/u/ppk96/profile/</url>
        </developer>
        <developer>
          <id>lamere</id>
          <name>Paul Lamere</name>
          <url>http://research.sun.com/research/speech/people/</url>
        </developer>
        <developer>
          <id>nshmyrev</id>
          <name>Nickolay V. Shmyrev</name>
          <url>http://alphacephei.com</url>
        </developer>
        <developer>
          <id>holgerbrandl</id>
          <name>Holger Brandl</name>
          <url>http://aiweb.techfak.uni-bielefeld.de/user/4</url>
        </developer>
        <developer>
          <id>egouvea</id>
          <name>Evandro Gouvea</name>
          <url>http://www-2.cs.cmu.edu/~egouvea/</url>
        </developer>
        <developer>
          <id>peter_wolf</id>
          <name>Peter Wolf</name>
          <url>http://www.merl.com/people/wolf/</url>
        </developer>
        <developer>
          <id>wwalker</id>
          <name>Willie Walker</name>
          <url>http://research.sun.com/research/speech/people/</url>
        </developer>
        <developer>
          <id>yanivkunda</id>
          <name>Yaniv Kunda</name>
          <!-- <url></url> -->
        </developer>
        <developer>
          <id>mbait</id>
          <name>Alexander Solovets</name>
          <url>https://github.com/mbait</url>
        </developer>
        <developer>
          <id>schnelle</id>
          <name>Dirk Schnelle-Walka</name>
          <url>http://www.tk.informatik.tu-darmstadt.de/de/people/dr-dirk-schnelle-walka/</url>
        </developer>
        <developer>
          <id>sumpfork</id>
          <name>Peter Gorniak</name>
          <url>http://sourceforge.net/u/sumpfork/profile/</url>
        </developer>
        <developer>
          <id>ariani</id>
          <name>Tjandra Ariani Hadi</name>
          <url>http://sourceforge.net/u/ariani/profile/</url>
        </developer>
        <developer>
          <id>bic-user</id>
          <name>bic-user</name>
          <url>http://sourceforge.net/u/bic-user/profile/</url>
        </developer>
        <developer>
          <id>jkwoelfel</id>
          <name>Joe Woelfel</name>
          <url>http://www.talkhouse.com/</url>
        </developer>
        <developer>
          <id>sciss</id>
          <name>Hanns Holger Rutz</name>
          <url>http://www.sciss.de</url>
        </developer>
      </developers>
  }
)

lazy val root = Project(id = baseNameL, base = file("."))
  .aggregate(core, data, samples)
  .dependsOn(core, data)
  .settings(commonSettings)
  .settings(
    name              := baseName,
    description       := s"$baseName core and data",
    // packagedArtifacts := Map.empty
    publishArtifact in(Compile, packageBin) := false, // there are no binaries
    publishArtifact in(Compile, packageDoc) := false, // there are no javadocs
    publishArtifact in(Compile, packageSrc) := false  // there are no sources
  )

lazy val core = Project(id = s"$baseNameL-core", base = file(s"$baseNameL-core"))
  .dependsOn(data % "test->compile")
  .settings(commonSettings, testNGSettings)
  .settings(
    description := s"$baseName core",
    resolvers += Resolver.sbtPluginRepo("releases"), // cf. https://github.com/sbt/sbt-testng-interface/issues/9
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-math3"    % "3.6",
      "org.testng"         % "testng"           % "6.8.8" % "test",
      "org.hamcrest"       % "hamcrest-library" % "1.3"   % "test"
    )
  )

lazy val data = Project(id = s"$baseNameL-data", base = file(s"$baseNameL-data"))
  .settings(commonSettings)
  .settings(
    description := s"$baseName US English models",
    publishArtifact in (Compile, packageSrc) := false,  // this would be a duplication
    publishArtifact in (Compile, packageDoc) := false   // no Java sources
  )

lazy val samples = Project(id = s"$baseNameL-samples", base = file(s"$baseNameL-samples"))
  .dependsOn(core, data)
  .settings(commonSettings)
  .settings(
    description := s"$baseName demo applications",
    mainClass in (Compile, run) := Some("edu.cmu.sphinx.demo.DemoRunner")
  )
