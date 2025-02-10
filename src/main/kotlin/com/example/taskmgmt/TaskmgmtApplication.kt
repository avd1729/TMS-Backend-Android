package com.example.taskmgmt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskmgmtApplication

fun main(args: Array<String>) {
	runApplication<TaskmgmtApplication>(*args)
}
