package com.rishika.todoapp.screens

import com.rishika.todoapp.data.Task

data class TaskUIState(
    val tasks: List<Task> = emptyList(),
    val error: String="",
    val status: String="",
    val editTaskMsg: String="",
    val isTaskImportant: Boolean=false,
    val isSheetOpen: Boolean =  false
)
