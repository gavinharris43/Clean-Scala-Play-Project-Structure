package controllers

import javax.inject._
import models.LoginDetails
import play.api.mvc._

@Singleton
class LoginController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport{

  def loginSubmit()= Action{ implicit request: Request[AnyContent] =>
    LoginDetails.loginForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.login(formWithErrors))
    }, { loginDetails =>
      if(LoginDetails.checkIfUserIsVali(loginDetails)) {
        Redirect(routes.HomeController.index()).withSession(request.session + ("username" -> loginDetails.username))
      }
    else{
      Ok("invalid input")
    }
    }
    )
  }

  def login()= Action{ implicit request: Request[AnyContent] =>
      Ok(views.html.login(LoginDetails.loginForm))
  }

}
