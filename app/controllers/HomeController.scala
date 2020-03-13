package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index("hello"))
  }
  def hello(msg: String) = Action {
    Ok(views.html.index(msg))
  }
  def hello1 = Action{
    Ok(views.html.index("Hello World!!!"))
  }
  def name = Action{
    Ok(views.html.name())
  }

}
