package com.example.taskmgmt.service.task

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task
import com.example.taskmgmt.repo.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) : ATaskService() {

    private inline fun <T> withTask(id: Long, action: (Task) -> T): T {
        val task = repository.findById(id)
            .orElseThrow { NoSuchElementException("Task with ID $id not found") }
        return action(task)
    }

    override fun addTask(task: Task): Task = repository.save(task)

    override fun getTaskById(id: Long): Task = withTask(id) { it }

    override fun getTasks(): List<Task> = repository.findAll()

    override fun filterTasks(taskStatus: TaskStatus): List<Task> = repository.findTasksByTaskStatus(taskStatus)

    override fun updateTask(task: Task, taskId: Long): Task = withTask(taskId) {
        it.title = task.title
        it.description = task.description
        it.taskStatus = task.taskStatus
        repository.save(it)
    }

    override fun getCountOfAllTasks(): Int {
        fun countTasksRecursively(tasks: List<Task>, index: Int = 0): Int {
            return if (index == tasks.size) 0 else 1 + countTasksRecursively(tasks, index + 1)
        }

        return countTasksRecursively(getTasks())
    }

    private tailrec fun countTasksTailRec(tasks: List<Task>, index: Int = 0, count: Int = 0): Int {
        return if (index == tasks.size) count else countTasksTailRec(tasks, index + 1, count + 1)
    }

    override fun getCountOfTasksByStatus(taskStatus: TaskStatus): Int = filterTasks(taskStatus).size

    override fun deleteTask(taskId: Long): Task = withTask(taskId) {
        repository.deleteById(taskId)
        return it
    }
}
