package com.rishika.todoapp.screens

sealed class TaskEvent{
    object AddTask : TaskEvent()
    data class UpdateTask(val name: String, val isComplete:Boolean) : TaskEvent()
    data class EditTaskName(val name: String) : TaskEvent()
    data class EditTaskImportance(val isImportant: Boolean) : TaskEvent()
    data object ToggleSheet: TaskEvent()
}
