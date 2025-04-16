package com.server.kotlinemailsender.domain.email.repository

import com.server.kotlinemailsender.domain.email.domain.entity.MailJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MailRepository : JpaRepository<MailJpaEntity, Long> {
}