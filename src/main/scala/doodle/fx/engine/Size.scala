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
package fx
package engine

sealed abstract class Size extends Product with Serializable
object Size {

  // Algebraic data type members

  final case class FixedSize(width: Double, height: Double) extends Size
  final case object FullScreen extends Size

  // Smart constructors

  def fixedSize(width: Double, height: Double): Size =
    FixedSize(width, height)

  val fullScreen: Size = FullScreen
}
