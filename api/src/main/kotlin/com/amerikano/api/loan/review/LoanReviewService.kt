package com.amerikano.api.loan.review

import com.amerikano.domain.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String): LoanReview?
}