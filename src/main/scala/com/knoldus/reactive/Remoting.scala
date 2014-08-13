package com.knoldus.reactive

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

object Remoting extends App {

  val config = """akka {
  actor {
    provider = "akka.remote.RemoteActorRefProvider"
  }
  remote {
    enabled-transports = ["akka.remote.netty.tcp"]
    netty.tcp {
      hostname = "127.0.0.1"
      port = 2552
    }
 }
}"""

  val configuration = ConfigFactory.parseString(config)
  val actorSystem = ActorSystem("remoteSystem", ConfigFactory.load(configuration))

  val helloActor = actorSystem.actorOf(Props[HelloActor], "helloActor")
  println(helloActor)
}

