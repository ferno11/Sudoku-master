package com.yourorg.sudukomasterf.core.board

data class BoardConfig(
    val boxSize: Int
){
    val boardSize: Int = boxSize * boxSize

    init{
        require(boxSize > 1)
    }
}