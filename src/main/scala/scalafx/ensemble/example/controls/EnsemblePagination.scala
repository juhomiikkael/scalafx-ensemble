/*
 * Copyright (c) 2012, ScalaFX Ensemble Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.ensemble.example.controls

import javafx.util.Callback
import scalafx.ensemble.commons.EnsembleExample
import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.scene.control.Button
import scalafx.scene.control.Control
import scalafx.scene.control.Label
import scalafx.scene.control.Pagination
import scalafx.scene.control.Pagination.sfxPagination2jfx
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout.Priority
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font
import scalafx.scene.text.Text

class EnsemblePagination extends EnsembleExample {
  def getContent = {
    //Images to load pages
    val images = new Array[Image](7)
    for (i <- 0 until 7) {
      images(i) = new Image(this.getClass.getResourceAsStream("/scalafx/ensemble/images/animals-200x200/animal" + (i + 1) + ".jpg"))
    }
    //Pagination with 7 pages and index starts at zero
    val pagination = new Pagination(7, 0)
    val indexToNode = (index: Int) => {
      val vbox = new VBox() {
        content = List(new ImageView(images(index)), new Label("PAGE " + (index + 1)))
      }.asInstanceOf[Node]
      vbox
    }

    /*pagination.pageFactory = indexToNode
    pagination.setPageFactory(new Callback[java.lang.Integer, javafx.scene.Node]() {
      override def call(index: Int) {
        new VBox() {
          content = List(
            new ImageView(images(index)),
            new Label("PAGE " + (index + 1)))
          println("Inside Pagination " + index)
        }.asInstanceOf[javafx.scene.Node]
      }
    })*/

    //TODO pagination incomplete
    new VBox {
      vgrow = Priority.ALWAYS
      hgrow = Priority.ALWAYS
      spacing = 10
      margin = Insets(50, 0, 0, 50)
      content = List(
        new Text {
          text = "Ensemble Pagination"
          font = new Font("Verdana", 20)
        },
        pagination,
        new Button {
          maxWidth = Control.USE_PREF_SIZE
          maxHeight = Control.USE_PREF_SIZE
          text = "Toggle Pagination Button"
        })
    }
  }
}