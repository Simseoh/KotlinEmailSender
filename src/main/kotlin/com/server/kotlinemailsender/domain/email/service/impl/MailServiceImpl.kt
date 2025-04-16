package com.server.kotlinemailsender.domain.email.service.impl

import com.server.kotlinemailsender.domain.email.domain.entity.MailJpaEntity
import com.server.kotlinemailsender.domain.email.dto.response.SendAuthenticationNumberEmailResponse
import com.server.kotlinemailsender.domain.email.repository.MailRepository
import com.server.kotlinemailsender.domain.email.service.MailService
import jakarta.mail.internet.MimeMessage
import jakarta.transaction.Transactional
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
@Transactional
class MailServiceImpl(
    private val mailRepository: MailRepository,
    private val javaMailSender: JavaMailSender
    ) : MailService {
        private val senderEmail : String = "seohoon0707@gmail.com"

        override fun sendAuthenticationNumberEmail(email: String): SendAuthenticationNumberEmailResponse {
            val number : Int = ((Math.random() * (90000)).toLong() + 100000).toInt()
            val message : MimeMessage = javaMailSender.createMimeMessage();

                message.setFrom(senderEmail);
                message.setRecipients(MimeMessage.RecipientType.TO, email);
                message.setSubject("이메일 인증");

            var body : String = ""
            body += "<div style=\"width: 400px; margin: auto;\">"
            body += "<div style=\"border: 2px solid #ddd; border-radius: 8px; padding: 10px; padding-top: 1px; padding-bottom: 5px; text-align: center; background-color: #f9f9f9;\">"
            body += "<h2 style=\"font-family: Arial, sans-serif; color: #333;\">Verification Code</h2>"
            body += "<h3 style=\"font-family: Arial, sans-serif; color: #333;\">Enter the code below to sign up to Medinet.</h3>"
            body += "<div style=\"border: 2px solid #ddd; border-radius: 8px; padding: 20px; text-align: center; background-color: #f9f9f9;\">"
            body += "<h1 style=\"font-size: 32px; color: #007bff; margin: 0;\">" + number + "</h1>"
            body += "</div>";
            body += "</div>";
            body += "</div>";

            message.setText(body, "UTF-8", "html");

            javaMailSender.send(message);

            val authNum : MailJpaEntity = MailJpaEntity(
                email = email.replace("\"", ""),
                content = number.toString()
            )

            mailRepository.save(authNum)

            return SendAuthenticationNumberEmailResponse(authNum.email, authNum.content)
        }
}

