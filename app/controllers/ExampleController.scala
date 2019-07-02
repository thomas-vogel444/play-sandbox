package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ExampleController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def example = Action { implicit request =>
    Ok
  }
}
