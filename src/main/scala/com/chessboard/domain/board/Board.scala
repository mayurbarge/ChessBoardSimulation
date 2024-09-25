package com.chessboard.domain.board

case class Board(size: BoardSize) {
  def containsCell(cell: Cell) = {
    val (cellColumn, cellRow) = cell.cellNumber

    isCellWithinColumnRange(cellColumn) && isCellWithinRowRange(cellRow)
  }
  private def isCellWithinColumnRange(cellColumn: Int) = (1 to size.maxColumns).contains(cellColumn)

  private def isCellWithinRowRange(cellRow: Int) = (1 to size.maxRows).contains(cellRow)
}
