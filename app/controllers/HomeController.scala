package controllers

import javax.inject._

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json.Json
import models.{DepartmentModel, PeopleModel}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  val PeopleForm : Form[PeopleModel] = Form (
    mapping(
      "name" -> text,
      "salary" -> number,
      "department" -> text
    )(PeopleModel.apply)(PeopleModel.unapply)
  )

  val DepartmentForm : Form[DepartmentModel] = Form (
    mapping(
      "department" -> text
    )(DepartmentModel.apply)(DepartmentModel.unapply)
  )

  def index = Action {
    Ok(views.html.index(PeopleModel.show, PeopleModel.total, PeopleModel.average))
  }

  def add = Action { implicit request =>
    val record = PeopleForm.bindFromRequest.get
    PeopleModel.save(record)
    Redirect(routes.HomeController.index)
  }

  def getDepartmentData = Action { implicit request =>
    val department = DepartmentForm.bindFromRequest.get
    Ok(Json.toJson(List(PeopleModel.average(department), PeopleModel.total(department))))
  }

}
