package com.chessboard.domain.validations

import com.chessboard.domain.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers

class CellFiltersSpec extends AnyFunSpec with Matchers {

  describe("A Cell Filter") {
    it("should return false when cell is invalid") {
      new CellFilters {}.filterCondition(Cell('X', 1), Cell('A', 1)) shouldBe false
    }

    it("should return false when cell to filter and current cell is same") {
      new CellFilters {}.filterCondition(Cell('A', 1), Cell('A', 1)) shouldBe false
    }

    it("should return true when cell is within the bounds of board and not same as the cell to filter") {
      new CellFilters {}.filterCondition(Cell('A', 1), Cell('A', 2)) shouldBe true
    }
  }
}
