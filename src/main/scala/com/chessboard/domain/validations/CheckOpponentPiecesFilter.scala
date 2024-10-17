package com.chessboard.domain.validations
import com.chessboard.domain.board.{Cell}
import com.chessboard.domain.pieces.Piece

case class CheckOpponentPiecesFilter(gameState: scala.collection.Map[Piece, Cell]) extends MoveValidator {

  def run(previousPosition: Cell)(nextPosition: Cell): Boolean = {
      !gameState.values.toList.contains(previousPosition)
  }
}
