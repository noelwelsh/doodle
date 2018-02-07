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
package algebra

import doodle.core.Color

trait Style[A] extends doodle.algebra.Style[Drawing,A] {
  def fillColor(image: Drawing[A], fillColor: Color): Drawing[A] =
      Drawing.contextTransform(dc => dc.fillColor(fillColor))(image)

  def strokeColor(image: Drawing[A], strokeColor: Color): Drawing[A] =
      Drawing.contextTransform(dc => dc.strokeColor(strokeColor))(image)

  def noFill(image: Drawing[A]): Drawing[A] =
    Drawing.contextTransform(dc => dc.noFill)(image)

  def noStroke(image: Drawing[A]): Drawing[A] =
    Drawing.contextTransform(dc => dc.noStroke)(image)
}
