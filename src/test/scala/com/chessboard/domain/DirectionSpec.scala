package com.chessboard.domain

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DirectionSpec extends AnyFunSpec with Matchers {
  describe("Direction") {
    describe("East") {
      it("should transform cell at A3 by 2 places to reach at A5") {
        East.transformBy(2, Cell('A', 3)) shouldBe Cell('A', 5)
      }
    }

    describe("West") {
      it("should transform cell at B2 by 1 places to reach at B1") {
        West.transformBy(1, Cell('B', 3)) shouldBe Cell('B', 2)
      }
    }

    describe("North") {
      it("should transform cell at B2 by 4 places to reach at B6") {
        East.transformBy(4, Cell('B', 2)) shouldBe Cell('B', 6)
      }
    }

    describe("South") {
      it("should transform cell at D2 by 2 places to reach at D1") {
        East.transformBy(2, Cell('D', 3)) shouldBe Cell('D', 5)
      }
    }

    describe("NorthEast") {
      it("should transform cell at D3 by 2 places to reach at F5") {
        NorthEast.transformBy(2, Cell('D', 3)).cellNumber shouldBe Cell('F', 5).cellNumber
      }
    }

    describe("NorthWest") {
      it("should transform cell at C3 by 2 places to reach at A5") {
        NorthWest.transformBy(2, Cell('C', 3)) shouldBe Cell('A', 5)
      }
    }

    describe("SouthEast") {
      it("should transform cell at A1 by 5 places to reach at F6") {
        NorthEast.transformBy(5, Cell('A', 1)).cellNumber shouldBe Cell('F', 6).cellNumber
      }
    }

    describe("SouthWest") {
      it("should transform cell at A1 by 4 places to reach at A1") {
        SouthWest.transformBy(4, Cell('E', 5)).cellNumber shouldBe Cell('A', 1).cellNumber
      }
    }
  }
}