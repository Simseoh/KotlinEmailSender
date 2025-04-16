package com.server.kotlinemailsender.global.exception


class CustomException(
    val error : CustomError
) : RuntimeException(error.message)