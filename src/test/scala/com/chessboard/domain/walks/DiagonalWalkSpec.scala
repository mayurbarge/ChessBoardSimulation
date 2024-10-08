package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DiagonalWalkSpec extends AnyFunSpec with Matchers {
  describe("A Diagonal Walk") {
    describe("With Single Step") {
      it("should reach at D3, F3, D5, F5 when current position is E4 in one step") {
        DiagonalWalk.startWalk(1, Cell('E', 4)) should contain theSameElementsAs
          List(Cell('D', 3), Cell('F', 3),
            Cell('D', 5), Cell('F', 5))
      }
    }

    describe("With Multiple Step") {
      it("should reach B1, H1, B7, H7 from current position E4 in 3 steps") {
        DiagonalWalk.startWalk(3, Cell('E', 4)) should contain theSameElementsAs
          List(Cell('B', 1), Cell('H', 1),
            Cell('B', 7), Cell('H', 7))
      }
    }
  }

}
