package models

import play.api.libs.json.Json

/**
  * Created by user on 26.04.16.
  */
case class PeopleModel(name: String, salary: Integer, department: String)

object PeopleModel {
  implicit val People = Json.format[PeopleModel]
}