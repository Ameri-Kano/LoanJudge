package com.amerikano.api.product

import com.amerikano.api.common.CommonResponse
import com.amerikano.domain.enum.Organization

interface ProductInformationService {
    fun saveProductInfo(productInformationDto: ProductInformationDto.RequestDto)
        : CommonResponse.CommonResponseDto

    fun findProductInfo(organizationCode: Organization)
        : ProductInquiryDto.ResponseDto
}