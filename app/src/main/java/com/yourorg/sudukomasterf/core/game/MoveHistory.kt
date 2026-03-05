package com.yourorg.sudukomasterf.core.game

class MoveHistory{
    private val undoStack = ArrayDeque<Move>()
    private val redoStack = ArrayDeque<Move>()

    fun recordMove(move: Move){
        undoStack.addLast(move)
        redoStack.clear()
    }

    fun undo(): Move?{
        val move = undoStack.removeLastOrNull() ?: return null
        redoStack.addLast(move)
        return move
    }

    fun redo(): Move?{
        val move = redoStack.removeLastOrNull() ?: return null
        undoStack.addLast(move)
        return move
    }

    fun canUndo(): Boolean{
        return undoStack.isNotEmpty()
    }

    fun canRedo(): Boolean{
        return redoStack.isNotEmpty()
    }

    fun clear(){
        undoStack.clear()
        redoStack.clear()
    }
}
