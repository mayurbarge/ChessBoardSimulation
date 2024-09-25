package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import com.chessboard.domain.moves.{CompositeMove, Move, SimpleMove}

trait Walk {
  def allowedMoves: List[Move]
  def startWalk(nthStep: Int, initial: Cell) = {
    val nextPositionsList = applyMoves(nthStep, allowedMoves)
    nextPositionsList.map(_(initial))
  }

  def startWalkAndCheckRestrictedMoves(nthStep: Int, initial: Cell, condition: Cell => Boolean): List[Cell] = {
    val nextPositions = startWalk(nthStep, initial)
    nextPositions.filter(condition(_))
  }
  protected def applyMoves(nthStep: Int, allowedMoves: List[Move]) = {
    allowedMoves.map {
      case SimpleMove(direction, steps) => direction.shiftTowardsBy(steps * nthStep)
      case CompositeMove(moves) =>
        moves.map(simpleMove => simpleMove.direction.shiftTowardsBy(simpleMove.steps * nthStep)).reduce(_ andThen _)
    }
  }
}