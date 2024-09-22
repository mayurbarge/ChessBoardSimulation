package com.chessboard.domain

import cats.data.Validated
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DirectionSpec extends AnyFunSpec with Matchers {
  describe("Direction") {
    describe("East") {
      it("should transform cell at A3 by 2 places to reach at C3") {
        East.shiftTowardsBy(2)(Cell('A', 3)) shouldBe Cell('C', 3)
      }
    }

    describe("West") {
      it("should transform cell at B2 by 1 places to reach at A2") {
        West.shiftTowardsBy(1)(Cell('B', 2)) shouldBe Cell('A', 2)
      }
    }

    describe("North") {
      it("should transform cell at B2 by 4 places to reach at B6") {
        North.shiftTowardsBy(4)(Cell('B', 2)) shouldBe Cell('B', 6)
      }
    }

    describe("South") {
      it("should transform cell at D2 by 2 places to reach at D1") {
        South.shiftTowardsBy(2)(Cell('D', 3)) shouldBe Cell('D', 1)
      }
    }

    describe("NorthEast") {
      it("should transform cell at D3 by 2 places to reach at F5") {
        NorthEast.shiftTowardsBy(2)(Cell('D', 3)).cellNumber shouldBe Cell('F', 5).cellNumber
      }
    }

    describe("NorthWest") {
      it("should transform cell at C3 by 2 places to reach at A5") {
        NorthWest.shiftTowardsBy(2)(Cell('C', 3)) shouldBe Cell('A', 5)
      }
    }

    describe("SouthEast") {
      it("should transform cell at A6 by 5 places to reach at F1") {
        SouthEast.shiftTowardsBy(5)(Cell('A', 6)) shouldBe Cell('F', 1)
      }
    }

    describe("SouthWest") {
      it("should transform cell at A1 by 4 places to reach at A1") {
        SouthWest.shiftTowardsBy(4)(Cell('E', 5)) shouldBe Cell('A', 1)
      }
    }

    describe("West") {
      val boardSize = BoardSize(8,8)
      it("should return invalid cell at A1 when transformed by 2 places") {
        val cell: Cell = SouthWest.shiftTowardsBy(2)(Cell('A', 1))
        ValidatedCell(cell, boardSize).leftMap(_.getMessage) shouldBe Validated.Invalid("Cell is invalid.")
      }
    }
  }
}