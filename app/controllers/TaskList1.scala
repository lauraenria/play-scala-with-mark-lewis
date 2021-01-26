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

  def taskList: Action[AnyContent] = Action {
    val tasks = List("Coffee", "Tea", "Milk")
    Ok(views.html.taskList1(tasks))
  }
}
