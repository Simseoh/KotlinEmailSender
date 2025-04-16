package com.server.kotlinemailsender.global.exception

import org.springframework.http.HttpStatus

interface CustomError {
    val status: HttpStatus
    val message: String
}
