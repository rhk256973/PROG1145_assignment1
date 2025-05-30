package com.conestoga.myapplication
import android.util.Log


//---part1.2 -> Add a new task to a mutable list of tasks---
val taskList = mutableListOf<Task>()

// It is a function to add a task to the list
fun addTask(task: Task) {
    taskList.add(task)
    // print a message to Logcat
    Log.d("TaskManager", "Task added: $task")
}


//---part1.2 -> Filter and return tasks that are incomplete
fun getIncompleteTasks(): List<Task> {
    return taskList.filter { !it.isCompleted }
}


//---part1.2 -> Print all task titles using a Kotlin collection method (e.g., map)
fun printTaskTitles() {
    val titles = taskList.map { it.title }
    Log.d("TaskManager", "Task Titles:")
    titles.forEach { title ->
        Log.d("TaskManager", title)
    }
}

// data model class (properties)
class Task(
    val id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean
) {
    // here's function changes isCompleted from true to false, or false to true
    fun toggleCompleted() {
        isCompleted = !isCompleted
    }

    // here makes object easy to print the task
    override fun toString(): String {
        return "Task(id=$id, title='$title', description='$description', isCompleted=$isCompleted)"
    }
}


// function to print only incomplete tasks(gets a list of tasks)
fun printIncompleteTasks(tasks: List<Task>) {
    for (task in tasks) { // loop through each task
        if (!task.isCompleted) { //if task is not completed
            Log.d("TaskManager", task.toString())
        }
    }
}