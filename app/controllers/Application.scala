/**
 * Copyright 2015 Adrian Hurtado (adrianhurt)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers

import javax.inject.Inject
import play.api.i18n.I18nSupport
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import scala.util.Failure
import models.Exercise

class Application @Inject() (mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {

  val inputForm = Form(single("input" -> list(text(maxLength = 500))))

  def index = Action { implicit request => Ok(views.html.index()) }

  def exercise(i: Int) = Action { implicit request =>
    val maybeExercise = Exercise.listOfExercises.lift(i)
    if (maybeExercise.nonEmpty) {
      Ok(views.html.exercise(i, inputForm))
    } else {
      Ok(views.html.index())
    }
  }

  def testExercise(i: Int) = Action {
    implicit request =>
      val maybeExercise = Exercise.listOfExercises.lift(i)
      maybeExercise.fold(Ok(views.html.exercise(i, inputForm))) { exercise =>
        inputForm.bindFromRequest.fold({
          formWithErrors =>
            Ok(views.html.exercise(i, inputForm, Some(Failure(new Exception("There was an error with the input: " + formWithErrors)))))
        }, {
          input: List[String] =>
            Ok(views.html.exercise(i, inputForm, Some(exercise.testInput(input))))
        })
      }
  }

}
