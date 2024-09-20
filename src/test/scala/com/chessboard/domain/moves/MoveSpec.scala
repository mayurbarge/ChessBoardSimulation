package com.chessboard.domain.moves

import com.chessboard.domain.Cell
import com.chessboard.domain.moves.{DiagonalMove, HorizontalMove, VerticalMove}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MoveWithRegularDirectionsSpec extends AnyFunSpec with Matchers {
  describe("A SingleStep Movement") {
    it("in horizontal direction should return A2, C2 when applied for a single step at position B2") {
      HorizontalMove.shift(1, Cell('B', 2)) should contain theSameElementsAs Seq(Cell('A', 2), Cell('C', 2))
    }

    it("in vertical direction should return D1 and D7 when applied for a 3 steps at position D4") {
      VerticalMove.shift(3, Cell('D', 4)) should contain theSameElementsAs List(Cell('D', 1), Cell('D', 7))
    }

    it("in diagonal direction should return B3, B7, F3 and D7 when applied for a 2 steps at position D5") {
      DiagonalMove.shift(2, Cell('D', 5)) should contain theSameElementsAs List(Cell('B', 3), Cell('B', 7), Cell('F', 3), Cell('F', 7))
    }
  }

  describe("A multistep movement") {
    it("in the horizontal direction should return A1, E3 when applied for 2 steps at C3") {
      HorizontalMove.shift(2, Cell('C', 3)) should contain theSameElementsAs List(Cell('A', 3), Cell('E', 3))
    }

    it("in the vertical direction should return C1, C5 when applied for 2 steps at C3") {
      VerticalMove.shift(2, Cell('C', 3)) should contain theSameElementsAs List(Cell('C', 1), Cell('C', 5))
    }

    it("in the horizontal direction should return C1, C5 when applied for 3 steps at D4") {
      DiagonalMove.shift(3, Cell('D', 4)) should contain theSameElementsAs List(
        Cell('A', 1), Cell('G', 1),
        Cell('A', 7), Cell('G', 7))
    }
  }
}
