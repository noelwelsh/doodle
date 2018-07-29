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
package algebra

/** Algebra describing color blending modes. */
trait Blend[F[_]] {
  def screen[A](image: F[A]): F[A]
  def burn[A](image: F[A]): F[A]
  def dodge[A](image: F[A]): F[A]
  def lighten[A](image: F[A]): F[A]
  def sourceOver[A](image: F[A]): F[A]
}
