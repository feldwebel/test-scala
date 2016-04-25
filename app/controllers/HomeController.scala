package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import models.PeopleModel
import models.DB
import play.api.data._
import play.api.data.Forms._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  val InputForm: Form[PeopleModel] = Form (
    mapping(
      "name" -> text,
      "salary" -> number,
      "department" -> text
    )(InputForm.apply)(InputForm.unapply)
  )

  def panel = Action {
    Ok(views.html.panel("panel"))
  }

  def add = Action { implicit request =>
    val record = InputForm.bindFromRequest.get
    DB.save(record)
    Redirect(routes.HomeController.panel)
  }

  def showAll = Action {
    Ok("Show All")
  }

  def showSalary = Action {
    Ok("Show Salary")
  }

  def find = Action {
    Ok("Find User")
  }

}
