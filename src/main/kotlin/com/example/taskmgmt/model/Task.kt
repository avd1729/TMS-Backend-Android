package com.example.taskmgmt.model

import com.example.taskmgmt.enums.TaskStatus
import java.time.LocalDateTime
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "tasks")
@Setter
@Getter
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    var title: String? = null,
    var description: String? = null,

    @Enumerated(EnumType.STRING)
    var taskStatus: TaskStatus = TaskStatus.TODO,

    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
