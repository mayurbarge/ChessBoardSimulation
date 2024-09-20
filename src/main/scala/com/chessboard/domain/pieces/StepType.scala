package com.chessboard.domain.pieces

sealed trait StepType
case object SingleStep extends StepType
case object MultiStep extends StepType