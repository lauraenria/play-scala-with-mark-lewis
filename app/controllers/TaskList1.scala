package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskList1 @Inject()(val cc: ControllerComponents) extends AbstractController(cc) {

  def login: Action[AnyContent] = Action {
    Ok(views.html.login1())
  }

  def validateLoginGet(username: String, password: String): Action[AnyContent] = Action {
    Ok(s"$username logged in with $password.")
  }

  def validateLoginPost: Action[AnyContent] = Action { request =>
    val postVals: Option[Map[String, Seq[String]]] = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username: Seq[String] = args("username")
      val password: Seq[String] = args("password")
      Ok(s"$username logged in with $password.")
    }.getOrElse(
      Ok(s"oop"))
  }

  def taskList: Action[AnyContent] = Action {
    val tasks: List[String] = List("Coffee", "Tea", "Milk")
    Ok(views.html.taskList1(tasks))
  }
}
