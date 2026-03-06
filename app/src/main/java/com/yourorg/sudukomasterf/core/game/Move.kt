package com.yourorg.sudukomasterf.core.game

import com.yourorg.sudukomasterf.core.model.Position

data class Move(
    val position: Position,
    val previousValue: Int?,
    val newValue: Int?,
)