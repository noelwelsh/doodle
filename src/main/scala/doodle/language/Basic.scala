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
package language

import doodle.algebra._

trait Basic[F[_],A] extends Layout[F,A] with Path[F,A] with Shape[F,A] with Style[F,A]
object Basic {
  def image[F[_],A](f: Basic[F,A] => F[A]): Image[Basic[F,A],F,A] =
    new Image[Basic[F,A],F,A] {
      def apply(implicit algebra: Basic[F,A]): F[A] =
        f(algebra)
    }
}