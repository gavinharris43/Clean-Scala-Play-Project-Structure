package controllers

import authentication.AuthenticationAction
import javax.inject._
import play.api.i18n.I18nSupport
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents, authAction: AuthenticationAction)
  extends AbstractController(cc) with I18nSupport {

  def index = authAction { implicit request =>
    Ok(views.html.index())
  }

  //  def hello(msg: String) = Action {
  //    Ok(views.html.index(msg))
  //  }

  def name = Action { implicit request =>
    Ok(views.html.name()())
  }

  def helloMsg = Action {
    Ok(views.html.helloMsg())
  }

  def function = Action {
    Ok(views.html.function())

  }

}
