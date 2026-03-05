package com.yourorg.sudukomasterf.core.game

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.model.Position
import com.yourorg.sudukomasterf.core.model.Cell

data class GameState(
    val board: Board,
    val solutionBoard: Board,
    val moveHistory: MoveHistory = MoveHistory(),
    val mistake : Int = 0,
    val elapsedTime: Long = 0L
){
    fun makeMove(position: Position, value: Int): GameState{
        val currentCell = board.getCell(position)

        val move = Move(
            position = position,
            previousValue = currentCell.value,
            newValue = value
        )
        val newBoard = board.setCell(position, Cell(value, false))

        val newHistory = moveHistory
        newHistory.recordMove(move)

        val solutionValue = solutionBoard.getCell(position).value

        val newMistake = if(value != null && value != solutionValue) mistake + 1 else mistake

        return copy(
            board = newBoard,
            moveHistory = newHistory,
            mistake = newMistake
        )
    }

    fun undo(): GameState{
        val move = moveHistory.undo() ?: return this
        val restoredBoard = board.setCell(move.position, Cell(move.previousValue, false))

        return copy(
            board = restoredBoard
        )
    }

    fun redo(): GameState{
        val move = moveHistory.redo() ?: return this

        val updatedBoard = board.setCell(move.position, Cell(move.newValue, false))
        return copy(
            board = updatedBoard
        )
    }
}