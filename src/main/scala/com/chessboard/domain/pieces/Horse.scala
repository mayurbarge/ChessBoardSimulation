package com.chessboard.domain.pieces
import com.chessboard.domain.moves.Move
import com.chessboard.domain.walks.Walk

case class Horse(allowedWalks: List[Walk]) extends Piece {
  override val stepType: StepType = SingleStep
}
