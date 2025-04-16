package com.server.kotlinemailsender.domain.email.dto.response

import com.server.kotlinemailsender.domain.email.domain.entity.MailJpaEntity

data class SendAuthenticationNumberEmailResponse(
    val email : String,
    val number : String
) {
}