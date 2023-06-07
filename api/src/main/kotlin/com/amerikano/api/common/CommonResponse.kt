package com.amerikano.api.common

import org.springframework.http.ResponseEntity

class CommonResponse(
    private val commonResponse: CommonResponseCode
) {
    fun toResponseEntity() = ResponseEntity
        .status(commonResponse.httpStatus)
        .body(
            CommonResponseDto(
                responseCode = commonResponse.code,
                responseMessage = commonResponse.message
            )
        )

    fun toResponseDto() = CommonResponseDto(
            commonResponse.code,
            commonResponse.message
        )

    data class CommonResponseDto(
        val responseCode: String,
        val responseMessage: String
    )
}