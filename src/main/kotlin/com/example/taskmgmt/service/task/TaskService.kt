package com.example.taskmgmt.service.task

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task
import com.example.taskmgmt.repo.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) : ATaskService() {

    override fun addTask(task: Task): Task {
        return repository.save(task)
    }

    override fun getTaskById(id: Long): Task {
        return repository.findById(id)
            .orElseThrow { NoSuchElementException("Task with ID $id not found") }
    }


    override fun getTasks(): List<Task> {
        return repository.findAll()
    }

    override fun filterTasks(taskStatus: TaskStatus): List<Task> {
        return repository.findTasksByTaskStatus(taskStatus)
    }

    override fun updateTask(task: Task, taskId: Long): Task {
        val oldTask = getTaskById(taskId)
        oldTask.title = task.title
        oldTask.description = task.description
        oldTask.taskStatus = task.taskStatus
        return repository.save(oldTask)
    }

    override fun getCountOfAllTasks(): Int {
        val tasks : List<Task> = getTasks()
        return tasks.size
    }

    override fun getCountOfTasksByStatus(taskStatus: TaskStatus): Int {
        val tasks : List<Task> = filterTasks(taskStatus)
        return tasks.size
    }

    override fun deleteTask(taskId: Long): Task {
        val task: Task = getTaskById(taskId)
        repository.deleteById(taskId)
        return task
    }
}