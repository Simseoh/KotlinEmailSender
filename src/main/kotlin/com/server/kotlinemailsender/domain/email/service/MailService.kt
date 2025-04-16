package com.server.kotlinemailsender.domain.email.service

import com.server.kotlinemailsender.domain.email.dto.response.SendAuthenticationNumberEmailResponse


interface MailService {
    fun sendAuthenticationNumberEmail(email : String) : SendAuthenticationNumberEmailResponse
}