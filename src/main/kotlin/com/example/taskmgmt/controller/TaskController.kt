package com.example.taskmgmt.controller

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task
import com.example.taskmgmt.service.task.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val service: TaskService) {

    @PostMapping("/add")
    fun addTask(@RequestBody task: Task) : Task{
        return service.addTask(task)
    }

    @GetMapping("/all")
    fun getAllTasks() : List<Task> {
        return service.getTasks()
    }

    @GetMapping("/get/{status}")
    fun getTasksByStatus(@PathVariable status: TaskStatus) : List<Task> {
        return service.filterTasks(status)
    }

    @PutMapping("/update/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: Task) : Task{
        return service.updateTask(task, id)
    }

    @GetMapping("/count")
    fun countOfTasks() : Int {
        return service.getCountOfAllTasks()
    }

    @GetMapping("/count/{status}")
    fun countOfTasksByStatus(@PathVariable status: TaskStatus) : Int {
        return service.getCountOfTasksByStatus(status)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteTask(@PathVariable id: Long) : Task {
        return service.deleteTask(id)
    }
}