package com.chessboard.domain.validations
import com.chessboard.domain.board.{Cell}
import com.chessboard.domain.pieces.Piece

case class CheckOpponentPiecesFilter(gameState: scala.collection.Map[Piece, Cell]) extends MoveValidator {

  def run(position: Cell): Boolean = {
      !gameState.values.toList.contains(position)
  }
}
