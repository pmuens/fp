package coinflip

import scala.util.Random
import coinflip.CoinFlipUtils._

import scala.annotation.tailrec

case class GameState(numFlips: Int, numCorrect: Int)

object CoinFlip extends App {
  val initialGameState = GameState(0, 0)
  val random = Random
  mainLoop(initialGameState, random)

  @tailrec
  def mainLoop(gameState: GameState, random: Random): Unit = {
    showPrompt()
    val userInput = getUserInput

    userInput match {
      case "H" | "T" =>
        val coinTossResult = tossCoin(random)
        val newNumFlips = gameState.numFlips + 1
        if (userInput == coinTossResult) {
          val newNumCorrect = gameState.numCorrect + 1
          val updatedGameState = gameState.copy(numFlips = newNumFlips, numCorrect = newNumCorrect)
          printGameState(printableFlipResult(coinTossResult), updatedGameState)
          mainLoop(updatedGameState, random)
        } else {
          val updatedGameState = gameState.copy(numFlips = newNumFlips)
          printGameState(printableFlipResult(coinTossResult), updatedGameState)
          mainLoop(updatedGameState, random)
        }
      case "N" =>
        val newGameState = GameState(0, 0)
        val random = Random
        mainLoop(newGameState, random)
      case _ =>
        printGameOver()
        printGameState(gameState)
    }
  }
}
