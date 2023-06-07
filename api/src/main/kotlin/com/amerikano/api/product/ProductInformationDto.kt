package com.amerikano.api.product

import com.amerikano.domain.domain.ProductInfo
import com.amerikano.domain.enum.findOrganizationCode
import com.amerikano.domain.enum.findProductCode

class ProductInformationDto {

    data class RequestDto(
        val organizationCode: String,

        val productCode: String,

        val productName: String,

        val productMinimumInterest: Double,

        val productMaximumInterest: Double
    ) {
        fun toEntity() = ProductInfo(
            findOrganizationCode(organizationCode),
            findProductCode(productCode),
            productName,
            productMinimumInterest,
            productMaximumInterest
        )
    }
}