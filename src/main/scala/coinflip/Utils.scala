package coinflip

import scala.io.StdIn.readLine
import scala.util.Random

// NOTE: you'll find impure functions since we're dealing with IO

object Utils {
  def showPrompt(): Unit = println("(h)eads, (t)ails, (n)ew game or (q)uit: ")

  def getUserInput: String = readLine.trim.toUpperCase

  def printableFlipResult(flip: String): String = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(flip: String, gameState: GameState): Unit = {
    print(s"flip was $flip. ")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit = {
    println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrect}")
  }

  def printGameOver(): Unit = println("=== Game Over ===")

  def tossCoin(r: Random): String = {
    val num = r.nextInt(2)
    num match {
      case 0 => "H"
      case 1 => "T"
    }
  }
}
