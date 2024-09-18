package com.chessboard.domain
import cats.data._
import cats.instances._
import cats.syntax._
import com.chessboard.errors.InvalidCellException
case class Cell(column: Char, row: Int) {
  def cellNumber = (column - 64, row)

}