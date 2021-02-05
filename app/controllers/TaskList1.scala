package controllers

import models.TaskListInMemoryModel

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
      val username: String = args("username").head
      val password: String = args("password").head
      if (TaskListInMemoryModel.validateUser(username, password)) {
        Redirect(routes.TaskList1.taskList())
      } else Redirect(routes.TaskList1.login())
    }.getOrElse(
      Redirect(routes.TaskList1.login()))
  }

  def taskList: Action[AnyContent] = Action {
    val tasks: List[String] = List("Coffee", "Tea", "Milk")
    Ok(views.html.taskList1(tasks))
  }
}
