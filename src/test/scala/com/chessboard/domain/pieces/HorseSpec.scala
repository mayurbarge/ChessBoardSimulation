package com.chessboard.domain.pieces

import com.chessboard.domain.{Cell, East, North, South, West}
import com.chessboard.domain.moves.ComplexMove
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers

class HorseSpec extends AnyFunSpec with Matchers {
  val horseMoves = List(ComplexMove(
    List(
      List((North, 2), (East, 1)),
      List((North, 2), (West, 1)),

      List((South, 2), (East, 1)),
      List((South, 2), (West, 1)),

      List((East, 2), (North, 1)),
      List((East, 2), (South, 1)),

      List((West, 2), (North, 1)),
      List((West, 2), (South, 1)),
    )
  ))

  val horse = Horse(horseMoves)

  describe("A Horse") {
    it("should calculate horse moves from E4 to reach F6, D6, F2, D2, G5, G3, C5, C3") {
      horse.allPossibleMoves(Cell('E', 4)) should contain theSameElementsAs
        List(Cell('F',6), Cell('D',6), Cell('F',2), Cell('D',2), Cell('G',5), Cell('G',3), Cell('C',5), Cell('C',3))
    }

    it("should calculate horse moves from H1 to reach G3, F2") {
      horse.allPossibleMoves(Cell('H', 1)) should contain theSameElementsAs
        List(Cell('F',2), Cell('G', 3))
    }

    it("should calculate horse moves from H8 to reach F7, G6") {
      horse.allPossibleMoves(Cell('H', 8)) should contain theSameElementsAs
        List(Cell('F',7), Cell('G', 6))
    }
  }
}
