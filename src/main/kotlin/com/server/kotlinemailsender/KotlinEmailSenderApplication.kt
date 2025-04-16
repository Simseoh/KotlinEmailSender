package com.server.kotlinemailsender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinEmailSenderApplication

fun main(args: Array<String>) {
    runApplication<KotlinEmailSenderApplication>(*args)
}
