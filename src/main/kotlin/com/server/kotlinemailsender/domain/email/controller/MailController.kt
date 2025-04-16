package com.server.kotlinemailsender.domain.email.controller

import com.server.kotlinemailsender.domain.email.dto.request.SendAuthenticationNumberEmailRequest
import com.server.kotlinemailsender.domain.email.dto.response.SendAuthenticationNumberEmailResponse
import com.server.kotlinemailsender.domain.email.service.MailService
import com.server.kotlinemailsender.global.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MailController(
    private val mailService : MailService
) {

    @PostMapping("/mail/send")
    @Operation(summary = "이메일 인증", description = "**request**\n\nemail : 인증번호를 전송할 이메일\n\n**response**\n\nemail : 인증번호를 전송한 이메일\n\nnumber : 전송한 인증번호")
    fun mailSend(@RequestBody request : SendAuthenticationNumberEmailRequest) : ResponseEntity<BaseResponse<SendAuthenticationNumberEmailResponse>> {
        return BaseResponse.of(mailService.sendAuthenticationNumberEmail(request.email), 200, "인증이메일 전송 완료")
    }
}

