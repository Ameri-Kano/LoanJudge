package com.amerikano.css.controller

import com.amerikano.css.dto.LoanRequestDto
import com.amerikano.css.dto.LoanResultDto
import com.amerikano.css.service.LoanReviewService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/css/api/v1")
class LoanReceiveController(
    private val loanReviewService: LoanReviewService
) {

    @PostMapping("/request")
    fun loanReceive(
        @RequestBody requestInputDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto =
        loanReviewService.loanReview(requestInputDto)

}