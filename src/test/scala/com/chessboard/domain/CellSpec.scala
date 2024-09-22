package com.chessboard.domain

import cats.data.Validated
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
class CellSpec extends AnyFunSpec with Matchers {
  val boardSize = BoardSize(8,8)

  describe("A Cell") {
    it("A7 should have column number 3") {
      Cell('A', 7).cellNumber shouldBe (1, 7)
    }

    it("should create cell from column number") {
      val (cellNumber, _) = Cell('A', 3).cellNumber

      Cell(cellNumber,3).cellNumber shouldBe Cell('A', 3).cellNumber
    }
  }

  describe("A Validated Cell") {
    it("should check if cell is valid for 8x8 chess board and return Invalid cell for Z2") {
      ValidatedCell('Z', 2, boardSize).isInvalid shouldBe true
    }

    it("should check if cell is valid for 8x8 chess board and return InvalidCellError for Z2") {
      ValidatedCell('Z', 2, boardSize).leftMap(_.getLocalizedMessage) shouldBe Validated.Invalid("Cell is invalid.")
    }

    it("should check if cell A3 is valid for 8x8 chess board") {
      ValidatedCell('A', 3, boardSize).isValid shouldBe true
    }

  }
}
