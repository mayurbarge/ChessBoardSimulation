package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import com.chessboard.domain.moves.{CompositeMove, Move, SimpleMove}
import com.chessboard.domain.validations.MoveValidator

trait Walk {
  def allowedMoves: List[Move]

  def startWalkAndCheckRestrictedMoves(maximumSteps: Int, initial: Cell, filters: List[MoveValidator]): List[Cell] = {

    val target = collection.mutable.Stack[Cell]()

    allowedMoves.map( move => {
      (1 to maximumSteps).takeWhile(step => {
        val next: Cell = startWalk(move, initial, step)
        val prevPosition = target.headOption

        if(MoveValidator.validateMoves(next,prevPosition, filters)) {
          target.push(next)
          true
        } else false
      })
    })
    target.toList
  }
  def startWalk(move: Move, initial: Cell, nthStep: Int) = {
    val nextPosition = move match {
      case SimpleMove(direction, unitStep) => direction.shiftTowardsBy(unitStep * nthStep)
      case CompositeMove(moves) =>
        moves.map(simpleMove => simpleMove.direction.shiftTowardsBy(simpleMove.steps * nthStep)).reduce(_ andThen _)
    }
    nextPosition(initial)
  }
}