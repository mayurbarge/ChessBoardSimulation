package com.chessboard.domain.pieces
import com.chessboard.domain.moves.Move

case class Horse(allowedMoves: List[Move]) extends Piece {
  override val stepType: StepType = SingleStep
}
