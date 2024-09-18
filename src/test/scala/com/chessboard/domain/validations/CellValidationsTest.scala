package com.chessboard.domain.validations

import cats.data.Validated
import com.chessboard.domain.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
class CellValidationsTest extends AnyFunSpec with Matchers {
  describe("A cell validator") {
    it("should return validation success for A1 cell") {
      val cell = Cell('A', 1)
      CellValidations.validateCell(cell).isValid shouldBe true
    }

    it("should return validation failure for A0 cell") {
      val cell = Cell('A', 0)
      CellValidations.validateCell(cell).isValid shouldBe false
    }

    it("should return validation failure for A9 cell") {
      val cell = Cell('A', 9)
      CellValidations.validateCell(cell).isValid shouldBe false
    }

    it("should return validation failure for I3 cell") {
      val cell = Cell('I', 3)
      CellValidations.validateCell(cell).isValid shouldBe false
    }

    it("should return InvalidCellError failure for J2 cell") {
      val cell = Cell('J', 2)
      CellValidations.validateCell(cell).leftMap(_.getMessage) shouldBe Validated.Invalid("Cell is invalid.")
    }
  }

}
