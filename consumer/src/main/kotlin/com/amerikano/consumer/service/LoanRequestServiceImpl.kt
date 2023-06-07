package com.amerikano.consumer.service

import com.amerikano.consumer.dto.ReviewResponseDto
import com.amerikano.domain.domain.LoanReview
import com.amerikano.domain.repository.LoanReviewRepository
import com.amerikano.kafka.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
) : LoanRequestService {
    companion object {
        const val nginxUrl = "http://nginx:8085/css/api/v1/request"
    }
    override fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCb(loanRequestDto)

        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    override fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        return restTemplate.postForEntity(nginxUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    override fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}