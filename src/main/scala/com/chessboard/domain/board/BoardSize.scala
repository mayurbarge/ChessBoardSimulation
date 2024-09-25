package com.chessboard.domain.board

case class BoardSize(maxRows: Int, maxColumns: Int) {
  val maxLength = Math.max(maxRows, maxColumns)
}
