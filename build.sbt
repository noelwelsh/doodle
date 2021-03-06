/*
 * Copyright 2017 Noel Welsh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

organization := "noelwelsh"
name := "doodle"
scalaVersion in ThisBuild := "2.12.6"

startYear := Some(2015)
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

enablePlugins(AutomateHeaderPlugin)

coursierUseSbtCredentials := true
coursierChecksums := Nil      // workaround for nexus sync bugs


lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    Dependencies.catsCore,
    Dependencies.catsEffect,
    Dependencies.miniTest,
    Dependencies.miniTestLaws
  ),

  initialCommands in console := """
      |import doodle.java2d._
      |import doodle.image._
      |import doodle.syntax._
      |import doodle.examples._
    """.trim.stripMargin,

  cleanupCommands in console := """
      |doodle.java2d.engine.Engine.stop()
    """.trim.stripMargin,

  addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.7" cross CrossVersion.binary)
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    initialCommands in console := """
      |import cats.instances.all._
      |import doodle.java2d._
      |import doodle.image._
      |import doodle.syntax._
      |import doodle.engine.Writer._
      |import doodle.examples._
      |import doodle.animate.java2d._
      |import doodle.animate.syntax._
      |import doodle.animate.examples._
      |import doodle.explore.java2d._
      |import doodle.explore.syntax._
      |import doodle.explore.examples._
    """.trim.stripMargin
  )
  .dependsOn(animate, core, explore)
  .aggregate(animate, core, explore)

lazy val core = (project in file("core"))
  .settings(commonSettings)

lazy val animate = (project in file("animate"))
  .settings(commonSettings,
            libraryDependencies += Dependencies.monix)
  .dependsOn(core)

lazy val explore = (project in file("explore"))
  .settings(commonSettings,
            libraryDependencies += Dependencies.magnolia)
  .dependsOn(core, animate)
