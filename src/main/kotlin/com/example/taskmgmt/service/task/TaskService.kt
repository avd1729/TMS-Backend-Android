package com.example.taskmgmt.service.task

import com.example.taskmgmt.model.Task

class TaskService : ATaskService() {
    override fun addTask(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun getTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun filterTasks(predicate: (Task) -> Boolean): List<Task> {
        TODO("Not yet implemented")
    }

    override fun updateTask(task: Task, taskId: Long): Task {
        TODO("Not yet implemented")
    }
}