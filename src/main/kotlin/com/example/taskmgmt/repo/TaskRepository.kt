package com.example.taskmgmt.repo

import com.example.taskmgmt.enums.TaskStatus
import com.example.taskmgmt.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findTasksByTaskStatus(taskStatus: TaskStatus) : List<Task>
}