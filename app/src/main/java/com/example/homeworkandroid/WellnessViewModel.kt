package com.example.homeworkandroid

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val predefinedTasks = getPredefinedMovies()


    private val userAddedTasks = getWellnessTasks().toMutableStateList()


    private val allTasks = (predefinedTasks + userAddedTasks).distinctBy { it.id }.toMutableList()


    val tasks: List<WellnessTask>
        get() = allTasks


    fun add(item: WellnessTask) {
        userAddedTasks.add(item)
        allTasks.add(item)
    }


    fun remove(item: WellnessTask) {
        userAddedTasks.remove(item)
        allTasks.remove(item)
    }


    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        item.checked = checked
    }


    private fun getPredefinedMovies(): List<WellnessTask> {
        return listOf(
            WellnessTask(1, "The Matrix"),
            WellnessTask(2, "Inception"),
            WellnessTask(3, "Interstellar"),
            WellnessTask(4, "Breaking Bad"),
            WellnessTask(5, "The office")

        )
    }
}
