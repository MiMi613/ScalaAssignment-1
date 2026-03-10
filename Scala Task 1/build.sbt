name := "Scala task 1"
version := "1.0"
scalaVersion := "3.3.1"
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)
Compile / mainClass := Some("Main")