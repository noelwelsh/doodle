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
package layout

/** A [[doodle.layout.BoundingBox]] represents a bounding box around an image.
  *
  * A bounding box also defines a local coordinate system for an image. The
  * bounding box must contain the origin of the coordinate system. However the
  * origin need not be centered within the box. 
  *
  * No particular guarantees are made about the tightness of the bounding box,
  * though it can assumed to be reasonably tight. */
final case class BoundingBox(left: Double,
                             top: Double,
                             right: Double,
                             bottom: Double) {
  def width: Double = right - left
  def height: Double = top - bottom

  def on(that: BoundingBox): BoundingBox =
    BoundingBox(this.left min that.left,
                this.top max that.top,
                this.right max that.right,
                this.bottom min that.bottom)

  def beside(that: BoundingBox): BoundingBox =
    BoundingBox(-this.width,
                this.top max that.top,
                that.width,
                this.bottom min that.bottom)
}

object BoundingBox {
  /** Create a [[doodle.layout.BoundingBox]] with the given width and heigh and
    * the origin centered within the box. */
  def centered(width: Double, height: Double): BoundingBox = {
    val w = width / 2.0
    val h = height / 2.0

    BoundingBox(-w, h, w, -h)
  }
}
