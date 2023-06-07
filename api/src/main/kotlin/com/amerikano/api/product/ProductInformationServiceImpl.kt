package com.amerikano.api.product

import com.amerikano.api.common.CommonResponse
import com.amerikano.api.common.CommonResponseCode
import com.amerikano.domain.enum.Organization
import com.amerikano.domain.repository.ProductInfoRepository
import org.springframework.stereotype.Service

@Service
class ProductInformationServiceImpl(
    private val productInfoRepository: ProductInfoRepository
) : ProductInformationService {
    override fun saveProductInfo(productInformationDto: ProductInformationDto.RequestDto)
            : CommonResponse.CommonResponseDto {
        val productInfo = productInformationDto.toEntity()

        productInfoRepository.save(productInfo)

        return CommonResponse(CommonResponseCode.SUCCESS).toResponseDto()
    }

    override fun findProductInfo(organizationCode: Organization)
            : ProductInquiryDto.ResponseDto {
        val data: ArrayList<ProductInquiryDto.ProductDataDto>
            = ArrayList()

        productInfoRepository
            .findAllByOrganizationCode(organizationCode)
            .forEach { p ->
                data.add(
                    ProductInquiryDto.ProductDataDto(
                        p.organizationCode.organizationCode,
                        p.productCode.productCode,
                        p.productName,
                        p.productMinimumInterest,
                        p.productMaximumInterest
                    )
                )
            }

        val okResponse = CommonResponse(CommonResponseCode.SUCCESS).toResponseDto()

        return ProductInquiryDto.ResponseDto(
            data = data,
            responseCode = okResponse.responseCode,
            responseMessage = okResponse.responseMessage
        )
    }
}