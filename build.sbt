lazy val root = project.in(file(".")).
  // (from: https://github.com/sbt/sbt/issues/3489)
  dependsOn(RootProject(uri("git://github.com/nwtgck/wiki-parser-scala.git#656a0c84c3edeb7233abd249d2d98a02a43b67a6"))).
  settings(
    inThisBuild(List(
      organization := "io.github.nwtgck",
      scalaVersion := "2.10.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "wiki-parser-prac-scala",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    fork := true // (from: https://github.com/saurfang/sbt-spark-submit/issues/4)
  )
