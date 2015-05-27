package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def calculateVolume(value: Int): Int = {
      value * value * value
  }
  
  def square(value: Int) = Action {
      Ok("square:" + value*value)
  }
 
  def volume(value: Int) = Action {
      Ok("Volume: " + calculateVolume(value))
  }

}