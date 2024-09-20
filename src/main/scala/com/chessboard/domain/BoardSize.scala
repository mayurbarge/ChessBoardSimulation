package com.chessboard.domain

case class BoardSize(maxRows: Int, maxColumns: Int) {
  val maxLength = Math.max(maxRows, maxColumns)
}
