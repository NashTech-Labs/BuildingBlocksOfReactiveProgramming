package com.knoldus.reactive

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object RemotingApp extends App {

  val configString = """akka {
  actor {
    provider = "akka.remote.RemoteActorRefProvider"
  }
  remote {
    enabled-transports = ["akka.remote.netty.tcp"]
    netty.tcp {
      hostname = "127.0.0.1"
      port = 2551
    }
 }
}"""
  val configuration = ConfigFactory.parseString(configString)

  val system = ActorSystem("system", ConfigFactory.load(configuration))

  val selection = system.actorSelection("akka.tcp://remoteSystem@127.0.0.1:2552/user/helloActor")

  selection ! Hello

}