package com.rishika.todoapp.screens

import androidx.lifecycle.ViewModel
import com.rishika.todoapp.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel: ViewModel() {

//    uistate
    private val _uiState = MutableStateFlow(TaskUIState())
    val uiState: StateFlow<TaskUIState> = _uiState

    //event handler
fun onEvent(event: TaskEvent) {
        when (event) {
            TaskEvent.AddTask -> addTask()
            is TaskEvent.UpdateTask -> {
                updateTask(event.name, event.isComplete)
            }

            is TaskEvent.EditTaskImportance -> {
                _uiState.update {
                    it.copy(isTaskImportant = event.isImportant)
                }
            }

            is TaskEvent.EditTaskName -> {
                _uiState.update {
                    it.copy(editTaskMsg = event.name)
                }

            }

            TaskEvent.ToggleSheet -> {
                _uiState.update {
                    it.copy(isSheetOpen = !it.isSheetOpen)
                }
            }
        }
    }

    private fun updateTask(name: String, complete: Boolean) {
        _uiState.value.tasks.forEachIndexed { index, task ->
            if (task.name == name){
                val updatedTasks = _uiState.value.tasks.toMutableList()
                updatedTasks[index] = task.copy(isCompleted = complete)
                _uiState.value = _uiState.value.copy(tasks = updatedTasks)
        }
        }
    }

    private fun addTask() {
        val updatedTasks = _uiState.value.tasks.toMutableList()
        updatedTasks.add(
            Task(
                name = _uiState.value.editTaskMsg,
                isImportant = _uiState.value.isTaskImportant
            )
        )
        _uiState.value = _uiState.value.copy(tasks = updatedTasks)
    }
}