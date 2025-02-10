package com.example.taskmgmt.model

import com.example.taskmgmt.enums.TaskStatus
import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,
    var description: String? = null,

    @Enumerated(EnumType.STRING)
    var taskStatus: TaskStatus = TaskStatus.TODO,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
