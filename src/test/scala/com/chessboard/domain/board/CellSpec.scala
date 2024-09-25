package com.chessboard.domain.board

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
}
