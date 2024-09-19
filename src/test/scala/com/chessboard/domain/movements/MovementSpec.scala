package com.chessboard.domain.movements

import com.chessboard.domain.{Cell, Direction, East, North, South, West}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers

class MovementSpec extends AnyFunSpec with Matchers {
  describe("A Movement") {
    it("in horizontal direction should return A2, C2 when applied for a single step at position B2") {
      HorizontalMove.shift(1, Cell('B', 2)) should contain theSameElementsAs Seq(Cell('A', 2), Cell('C', 2))
    }
  }

  describe("A Vertical Movement") {
    it("should return D1 and D7 when applied for a 3 steps at position D4") {
      VerticalMove.shift(3, Cell('D', 4)) should contain theSameElementsAs List(Cell('D', 1), Cell('D', 7))
    }
  }

  describe("A Diagonal Movement") {
    it("should return B3, B7, F3 and D7 when applied for a 2 steps at position D5") {
      DiagonalMove.shift(2, Cell('D', 5)) should contain theSameElementsAs List(Cell('B', 3), Cell('B', 7), Cell('F', 3), Cell('F', 7))
    }
  }

  describe("A Complex Movement") {
    it("should calculate a move at E5 from combination of 2 East and 3 South steps in succession to reach at G2") {
      val complexMovement = Move.buildComplexMove(List((East, 2), (South, 3)))
      complexMovement(Cell('E', 5)) shouldBe Cell('G', 2)
    }

    it("should return the same position for a circular path") {
      val complexMovement = Move.buildComplexMove(List((North, 2), (East, 2), (South, 2), (West, 2)))
      complexMovement(Cell('E', 5)) shouldBe Cell('E', 5)
    }
  }
}
