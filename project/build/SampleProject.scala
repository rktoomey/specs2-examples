import sbt._

class SampleProject(info: ProjectInfo) extends DefaultProject(info) {
    
    override def compileOptions = super.compileOptions ++ Seq(Unchecked, Deprecation)
    
     val specs2 = "org.specs2" %% "specs2" % "1.4"

     def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")
     override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)

     val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"
     val releases  = "releases" at "http://scala-tools.org/repo-releases"

}
