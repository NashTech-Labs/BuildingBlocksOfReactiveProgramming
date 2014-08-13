package com.knoldus.reactive

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.pattern.ask
import scala.concurrent.duration._
import akka.util.Timeout
import scala.concurrent.Await
import scala.util.Success
import scala.util.Failure
import scala.concurrent.ExecutionContext.Implicits.global

object FutureApp extends App {

  implicit val timeout = Timeout(10 seconds)

  val actorSystem = ActorSystem("system")

  val helloActor = actorSystem.actorOf(Props[HelloActor], "helloActor")

  val future = helloActor ? Hello

//  val result = Await.result(future, 10 seconds)

  future onComplete {

    case Success(result) => println(result)
    case Failure(fail) =>

  }

  println("done.........")

}

