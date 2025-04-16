package com.server.kotlinemailsender.global.exception

import org.springframework.http.HttpStatus

enum class GlobalError(
    override val status: HttpStatus,
    override val message: String
) : CustomError {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "Input Value Wrong");
}
