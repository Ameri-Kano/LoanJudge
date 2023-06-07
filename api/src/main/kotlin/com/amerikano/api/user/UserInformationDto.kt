package com.amerikano.api.user

class UserInformationDto {

    data class KeyAndNumber(
        val userKey: String,
        val userRegistrationNumber: String
    )
    data class ResponseDto(
        val data: KeyAndNumber,
        val responseCode: String,
        val responseMessage: String
    )
}