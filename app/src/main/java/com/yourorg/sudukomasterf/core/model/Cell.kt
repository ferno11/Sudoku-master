package com.yourorg.sudukomasterf.core.model

data class Cell(
    val value: Int?, // for no in cell
    val isFixed: Boolean, //true for original puzzle part
    val notes: Set<Int> = emptySet() // for notes
)