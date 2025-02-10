package com.example.taskmgmt.service.task

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task
import com.example.taskmgmt.repo.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) : ATaskService() {

    override fun addTask(task: Task): Task {
        val newTask = Task()
        newTask.title = task.title
        newTask.description = task.description
        newTask.taskStatus = task.taskStatus
        return repository.save(newTask)
    }

    override fun getTasks(): List<Task> {
        return repository.findAll()
    }

    override fun filterTasks(taskStatus: TaskStatus): List<Task> {
        return repository.findTasksByTaskStatus(taskStatus)
    }

    override fun updateTask(task: Task, taskId: Long): Task {
        TODO("Not yet implemented")
    }

    override fun getCountOfAllTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getCountOfTasksByStatus(taskStatus: TaskStatus): List<Task> {
        TODO("Not yet implemented")
    }
}