/*
 * Copyright 2015 noelwelsh
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

package doodle
package java2d
package algebra

import cats.effect.IO
import doodle.algebra.Image
import doodle.engine.Frame
import doodle.java2d.engine.Engine

object Renderer extends doodle.algebra.Renderer[Algebra,Drawing] {
  def render[A](image: Image[Algebra,Drawing,A]): IO[A] = {
    Engine.frame(Frame.size(400,400))(algebra => image(algebra))
  }
}