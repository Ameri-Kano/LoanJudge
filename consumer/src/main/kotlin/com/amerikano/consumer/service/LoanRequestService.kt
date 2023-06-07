package com.amerikano.consumer.service

import com.amerikano.consumer.dto.ReviewResponseDto
import com.amerikano.domain.domain.LoanReview
import com.amerikano.kafka.dto.LoanRequestDto

interface LoanRequestService {
    fun loanRequest(loanRequestDto: LoanRequestDto)

    fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto

    fun saveLoanReviewData(loanReview: LoanReview): LoanReview
}