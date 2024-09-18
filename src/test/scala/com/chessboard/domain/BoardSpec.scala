package com.chessboard.domain

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
trait WithTestData {
  val sizeEightByEight = BoardSize(8, 8)
  val oneByOne = BoardSize(1, 1)
  val zero = BoardSize(0, 1)
}

class BoardSpec extends AnyFunSpec with Matchers with WithTestData {
  describe("A Board") {
    describe("with size 8x8") {
      it("should contain A7 cell") {
        Board(sizeEightByEight).containsCell(Cell('A', 7)) shouldBe true
      }

      it("should contain H8 cell") {
        Board(sizeEightByEight).containsCell(Cell('H', 8)) shouldBe true
      }

      it("should not contain H9 cell") {
        Board(sizeEightByEight).containsCell(Cell('H', 9)) shouldBe false
      }

      it("should not contain A0 cell") {
        Board(sizeEightByEight).containsCell(Cell('A', 0)) shouldBe false
      }

      it("should not contain I3 cell") {
        Board(sizeEightByEight).containsCell(Cell('I', 3)) shouldBe false
      }
    }
  }

  describe("with size 1x1") {
    it("should contain A1 cell") {
      Board(oneByOne).containsCell(Cell('A', 1)) shouldBe true
    }

    it("should not A2 cell") {
      Board(oneByOne).containsCell(Cell('A', 2)) shouldBe false
    }
  }

  describe("with size 0") {
    it("should contain A1 cell") {
      Board(zero).containsCell(Cell('A', 1)) shouldBe false
    }
  }
}