package com.amerikano.api.user

import com.amerikano.domain.domain.UserInfo


class UserRegistrationDto {
    data class RequestDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )
    }

    data class UserInfoDto(
        val userKey: String,
        val userName: String,
        var userRegistrationNumber: String,
        val userIncomeAmount: Long
    ) {
        fun toEntity() =
            UserInfo(
                userKey, userRegistrationNumber, userName, userIncomeAmount
            )
    }

    data class UserKey(
        val userKey: String
    )

    data class ResponseDto(
        val data: UserKey,
        val responseCode: String,
        val responseMessage: String
    )
}