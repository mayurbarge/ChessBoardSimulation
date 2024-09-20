package com.chessboard.domain.moves

import com.chessboard.domain.{Cell, Direction}

case class ComplexMove(complexMoves: List[List[(Direction, Int)]]) extends Move {
  override def shift(nthStep: Int, initial: Cell): List[Cell] = {
    val nextPositionsList = complexMoves.map(moves =>
      sequenceMultipleMovesIntoOne(applyMoves(nthStep, moves))
    )
    nextPositionsList.map(_(initial))
  }
  def sequenceMultipleMovesIntoOne(moves: List[Cell => Cell]): Cell => Cell = moves.reduce(_ andThen _)
}