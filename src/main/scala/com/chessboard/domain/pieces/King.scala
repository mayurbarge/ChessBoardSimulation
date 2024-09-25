package com.chessboard.domain.pieces

import com.chessboard.domain.walks.Walk

case class King(allowedWalks: List[Walk]) extends Piece {
  override val stepType: StepType = SingleStep
}