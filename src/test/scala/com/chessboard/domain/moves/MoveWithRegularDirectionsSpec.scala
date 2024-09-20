package com.chessboard.domain.moves

import com.chessboard.domain.moves.ComplexMove
import com.chessboard.domain.{Cell, East, North, South, West}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ComplexMoveSpec extends AnyFunSpec with Matchers {
  describe("A SingleStep Complex Movement") {
    it("should calculate a move at E5 from combination of 2 East and 3 South steps in succession to reach at G2") {
      val complexMovement = ComplexMove(List(List((East, 2), (South, 3))))
      complexMovement.shift(1, Cell('E', 5)) shouldBe List(Cell('G', 2))
    }

    it("should return the same position for a circular path") {
      val complexMovement = ComplexMove(List(List((North, 2), (East, 2), (South, 2), (West, 2))))
      complexMovement.shift(1, Cell('E', 5)) shouldBe List(Cell('E', 5))
    }
  }

  describe("A multistep Complex movement") {
    it("should calculate a move at A7 from combination of 1 East and 2 South in 2 steps to reach at G2") {
      val complexMovement = ComplexMove(List(List((East, 1), (South, 2))))
      complexMovement.shift(2, Cell('A', 7)) shouldBe List(Cell('C', 3))
    }
  }
}
