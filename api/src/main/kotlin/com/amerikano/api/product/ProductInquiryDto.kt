package com.amerikano.api.product

class ProductInquiryDto {

    data class ProductDataDto(
        val organizationCode: String,

        val productCode: String,

        val productName: String,

        val productMinimumInterest: Double,

        val productMaximumInterest: Double
    )
    data class ResponseDto(
        val data: List<ProductDataDto>,
        val responseCode: String,
        val responseMessage: String
    )
}