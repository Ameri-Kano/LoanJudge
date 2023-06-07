package com.amerikano.api.loan.review

import com.amerikano.api.exception.CustomErrorCode
import com.amerikano.api.exception.CustomException
import com.amerikano.domain.domain.LoanReview
import com.amerikano.domain.repository.LoanReviewRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = getLoanResult(userKey)?.toResponseDto()
                ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)
        )
    }

    @Cacheable(value = ["REVIEW"], key = "#userKey", cacheManager = "redisCacheManager")
    override fun getLoanResult(userKey: String) =
        loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
        LoanReviewDto.LoanResult(
            userLimitAmount = this.loanLimitedAmount,
            userLoanInterest = this.loanInterest
        )

}