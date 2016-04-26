package models

import scala.collection.immutable.List

/**
  * Created by user on 26.04.16.
  */
case class PeopleModel(name: String, salary: Int, department: String)

object PeopleModel {
  var records = List.empty[PeopleModel]

  def save(record: PeopleModel): Unit = {
    records = record :: records
  }

  def show(): List[PeopleModel] = {
    records.reverse
  }

  def find(name: String): Option[PeopleModel] = {
    records.find(r => r.name == name)
  }

  def total(): Int = records.map(_.salary).sum

  def average() {}

  def average(department: String) {}

  //  def totalSum(department: String): Int =
  //    records.filter(r => r.department == department).map(_.salary).sum
  //
  //  def averageSum(department: String): Float = {
  //    val items = records.filter(r => r.department == department).map(_.salary)
  //    items.sum / items.length
  //  }
  //
  //  def findUser(name: String): String =
  //    records.find(r => r.name == name).toString
}
