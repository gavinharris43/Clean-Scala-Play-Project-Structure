package controllers

import authentication.AuthenticationAction
import javax.inject._
import models.LoginDetails
import play.api.mvc._

@Singleton
class LoginController @Inject()(cc: ControllerComponents, authAction: AuthenticationAction) extends AbstractController(cc) with play.api.i18n.I18nSupport{

  def loginSubmit()= Action{ implicit request: Request[AnyContent] =>
    LoginDetails.loginForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.login(formWithErrors))
    }, { loginDetails =>
      if(LoginDetails.checkIfUserIsValid(loginDetails)) {
        Redirect(routes.HomeController.index()).withSession(request.session + ("username" -> loginDetails.username))
      }
    else{
      Ok("Incorrect username or password")
    }
    }
    )
  }

  def login()= Action{ implicit request: Request[AnyContent] =>
      Ok(views.html.login(LoginDetails.loginForm))
  }

  def logout() = authAction{
    implicit request =>
       Redirect("/").removingFromSession("username")
  }

}
