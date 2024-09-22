package com.chessboard.domain.pieces

import com.chessboard.domain.moves.Move

case class Queen(allowedMoves: List[Move]) extends Piece {
  override val stepType: StepType = MultiStep
}
