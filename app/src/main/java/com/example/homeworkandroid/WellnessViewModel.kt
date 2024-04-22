package com.example.homeworkandroid

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getPredefinedMovies().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    private fun getPredefinedMovies(): List<WellnessTask> {
        return listOf(
            WellnessTask(1, "The Matrix"),
            WellnessTask(2, "Inception"),
            WellnessTask(3, "Interstellar"),
            WellnessTask(4,"Breaking Bad"),
            WellnessTask(4,"The office"),

            // Adicione mais filmes conforme necessário
        )
    }

    fun add(item: WellnessTask) {
        _tasks.add(item)
    }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}