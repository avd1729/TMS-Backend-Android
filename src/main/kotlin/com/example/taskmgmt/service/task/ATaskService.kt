package com.example.taskmgmt.service.task

import com.example.taskmgmt.model.Task

abstract class ATaskService {
    abstract fun addTask(task: Task): Task
    abstract fun getTasks(): List<Task>
    abstract fun filterTasks(predicate: (Task) -> Boolean): List<Task>
    abstract fun updateTask(task: Task, taskId: Long) : Task
}