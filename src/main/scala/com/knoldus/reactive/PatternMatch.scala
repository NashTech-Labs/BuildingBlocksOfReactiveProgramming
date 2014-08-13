package com.knoldus.reactive

object PatternMatch extends App {

  
  doMatch(1)
  
  doMatch("String")
  
  doMatch(1.0)
  
  
  def doMatch(x: Any) = {

    x match {
      case x: Int => println("Its a Integer ")
      case x: String => println("Its a string")
      case _ => println("Its a something else")

    }

  }

}

