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

package object syntax
    extends AngleSyntax
    with BlendSyntax
    with EngineSyntax
    with ImageSyntax
    with LayoutSyntax
    with NormalizedSyntax
    with PathSyntax
    with StyleSyntax
    with TraverseSyntax
    with UnsignedByteSyntax
    with WriterSyntax {
  object angle extends AngleSyntax
  object blend extends BlendSyntax
  object engine extends EngineSyntax
  object image extends ImageSyntax
  object layout extends LayoutSyntax
  object normalized extends NormalizedSyntax
  object path extends PathSyntax
  object style extends StyleSyntax
  object traverse extends TraverseSyntax
  object unsignedByte extends UnsignedByteSyntax
  object writer extends WriterSyntax
}
