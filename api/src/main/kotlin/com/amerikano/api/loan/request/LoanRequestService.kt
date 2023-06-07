package com.amerikano.api.loan.request

import com.amerikano.domain.domain.UserInfo

interface LoanRequestService {
    fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(
        userInfoDto: UserInfoDto
    ): UserInfo

    fun loanRequestReview(userInfoDto: UserInfoDto)
}