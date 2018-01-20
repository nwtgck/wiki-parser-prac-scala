lazy val root = project.in(file(".")).
  // (from: https://github.com/sbt/sbt/issues/3489)
  dependsOn(RootProject(uri("git://github.com/nwtgck/wiki-parser-scala.git#9632f9c2bd8602cdfa1ea51882bd8b1573c2de66"))).
  settings(
    inThisBuild(List(
      organization := "io.github.nwtgck",
      scalaVersion := "2.11.12",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "wiki-parser-prac-scala",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    fork := true // (from: https://github.com/saurfang/sbt-spark-submit/issues/4)
  )
