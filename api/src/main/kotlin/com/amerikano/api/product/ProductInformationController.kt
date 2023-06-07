package com.amerikano.api.product

import com.amerikano.api.common.CommonResponse
import com.amerikano.domain.enum.Organization
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("loanjudge/v1/product")
@Api(description = "상품 정보 API")
class ProductInformationController(
    private val productInformationService: ProductInformationService
) {
    @PostMapping("information")
    @ApiOperation(value = "상품 정보 등록", notes = "상품 정보를 등록하는 API")
    fun postProductData(
        @RequestBody productInformationDto: ProductInformationDto.RequestDto
    ): ResponseEntity<CommonResponse.CommonResponseDto> {

        return ResponseEntity
            .ok(productInformationService.saveProductInfo(productInformationDto))
    }

    @GetMapping("{organizationCode}")
    @ApiOperation(value = "상품 정보 조회", notes = "상품 정보를 조회하는 API")
    @ApiImplicitParam(name = "organizationCode", value = "기관 코드")
    fun getProductData(
        @PathVariable organizationCode: Organization
    ):ResponseEntity<ProductInquiryDto.ResponseDto> {
        return ResponseEntity
            .ok(productInformationService.findProductInfo(organizationCode))
    }

}