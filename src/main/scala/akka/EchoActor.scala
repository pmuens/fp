package akka

import akka.actor.Actor
import akka.messages.{Message, Quit}

class EchoActor extends Actor {
  def receive: PartialFunction[Any, Unit] = {
    case Message(s) => println(s"--> $s")
    case Quit => println("Bye!")
    case _ => println("Unknown message received")
  }
}
