package com.chessboard.domain.movements

sealed trait StepType
case object SingleStep extends StepType
case object MultiStep extends StepType