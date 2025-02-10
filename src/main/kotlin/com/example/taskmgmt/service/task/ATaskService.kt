package com.example.taskmgmt.service.task

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task

abstract class ATaskService {
    abstract fun addTask(task: Task): Task
    abstract fun getTasks(): List<Task>
    abstract fun filterTasks(taskStatus: TaskStatus): List<Task>
    abstract fun updateTask(task: Task, taskId: Long) : Task
    abstract fun getCountOfAllTasks() : List<Task>
    abstract fun getCountOfTasksByStatus(taskStatus: TaskStatus) : List<Task>
}