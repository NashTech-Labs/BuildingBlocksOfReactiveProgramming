package com.knoldus.reactive

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor

object ActorApp extends App {

  val actorSystem = ActorSystem("system")
  val helloActor = actorSystem.actorOf(Props[HelloActor], "helloActor")
  helloActor ! Hello
  println("Message has been sent to actor")
}

class HelloActor extends Actor {

  def receive: PartialFunction[Any, Unit] = {

    case Hello =>
      println("---------------------------------------------")
      println("Hello !!!!!")
      println("---------------------------------------------")
      sender ! "How are you?"
    case _ => println("I did not understand")
  }

}

case object Hello