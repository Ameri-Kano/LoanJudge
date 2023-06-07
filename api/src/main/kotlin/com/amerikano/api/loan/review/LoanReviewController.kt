package com.amerikano.api.loan.review

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loanjudge/api/v1")
class LoanReviewController(
    private val loanReviewServiceImpl: LoanReviewServiceImpl
) {

    @GetMapping("review/{userkey}")
    fun getReviewData(
        @PathVariable userkey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
            loanReviewServiceImpl.loanReviewMain(userkey)
        )
    }
}