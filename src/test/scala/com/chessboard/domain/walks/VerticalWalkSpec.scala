package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class VerticalWalkSpec extends AnyFunSpec with Matchers {
  describe("A Vertical Walk") {
    describe("With Single Step") {
      it("should move a piece D3 by 2 place to reach ") {
        VerticalWalk.startWalk(1, Cell('D', 3)) should contain theSameElementsAs List(Cell('D', 2), Cell('D', 4))
      }
    }

    describe("With Multiple Step") {
      it("should move a piece F3 by 2 places to reach F1, F5") {
        VerticalWalk.startWalk(2, Cell('F', 3)) should contain theSameElementsAs List(Cell('F', 1), Cell('F', 5))
      }
    }
  }

}
