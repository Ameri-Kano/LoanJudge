package com.amerikano.consumer.kafka

import com.amerikano.consumer.service.LoanRequestService
import com.amerikano.kafka.dto.LoanRequestDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper,
    private val loanRequestService: LoanRequestService
) {
    @KafkaListener(topics = ["loan_request"], groupId = "loanjudge")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)

        loanRequestService.loanRequest(loanRequestKafkaDto)
    }
}