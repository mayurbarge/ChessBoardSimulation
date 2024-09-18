package com.chessboard.domain

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
class CellSpec extends AnyFunSpec with Matchers {
  describe("A Cell") {
    it("A7 should have column number 3") {
      Cell('A', 7).cellNumber shouldBe (1, 7)
    }
  }
}
