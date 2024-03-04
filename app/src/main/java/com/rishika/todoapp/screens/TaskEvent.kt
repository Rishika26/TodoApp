package com.rishika.todoapp.screens

sealed class TaskEvent{
    object AddTask : TaskEvent()
    data class UpdateTask(val isComplete:Boolean) : TaskEvent()
}
