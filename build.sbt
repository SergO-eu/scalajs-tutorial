enablePlugins(ScalaJSPlugin)
enablePlugins(JSDependenciesPlugin)

name := "Scala.js Tutorial"
scalaVersion := "2.13.1"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "1.0.0"


// Add support for the DOM in `run` and `test`
jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

skip in packageJSDependencies := false
jsDependencies += "org.webjars" % "jquery" % "3.4.1" / "3.4.1/jquery.js"

// uTest settings
libraryDependencies += "com.lihaoyi" %%% "utest" % "0.7.4" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")
