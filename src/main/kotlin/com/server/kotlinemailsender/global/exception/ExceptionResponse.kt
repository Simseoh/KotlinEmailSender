package com.server.kotlinemailsender.global.exception

import org.springframework.http.ResponseEntity

class ExceptionResponse(
    var status: Int? = null,
    var code : String? = null,
    var message: String? = null
) {
    constructor(error : CustomError) : this(
        status = error.status.value(),
        code = (error as Enum<*>).name,
        message = error.message
    )

    fun of(error : CustomError) : ResponseEntity<ExceptionResponse> {
        return ResponseEntity.status(error.status.value()).body(ExceptionResponse(error))
    }
}
