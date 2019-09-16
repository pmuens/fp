package akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.messages.{Message, Quit}

import scala.io.StdIn

object Main extends App {
  val system = ActorSystem("EchoSystem")
  val echoActor = system.actorOf(Props[EchoActor], name="EchoActor")

  var input = ""
  while (input != "q") {
    println("Type something (or (q)uit): ")
    input = StdIn.readLine()
    echoActor ! Message(input)
    // give the actor some time to print the message
    Thread.sleep(200)
  }

  echoActor ! Quit

  // shutdown the system
  system.terminate()
}
