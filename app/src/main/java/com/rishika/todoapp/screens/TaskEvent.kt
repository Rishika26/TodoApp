package com.rishika.todoapp.screens

sealed class TaskEvent{
    object addTask : TaskEvent()
    data object updateTask(val isComplete:Boolean) : TaskEvent()
}
