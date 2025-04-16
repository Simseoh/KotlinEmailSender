package com.server.kotlinemailsender.global

import org.springframework.http.ResponseEntity

data class BaseResponse<T>(
    val data : T,
    val status : Int,
    val message: String
) {
    companion object {
        fun <T> of (data : T, status : Int, message : String) : ResponseEntity<BaseResponse<T>> {
            return ResponseEntity.status(status).body(BaseResponse(data, status, message))
        }
    }

}