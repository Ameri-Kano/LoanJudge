package com.amerikano.api.user

import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/loanjudge/v1/user")
@Api(description = "유저 정보 API")
class UserInformationController(
    private val userInformationService: UserInformationService
) {
    @PostMapping("information")
    @ApiOperation(value = "유저 정보 등록", notes = "유 정보를 등록하는 API")
    fun registerUser(
        @RequestBody userInfo: UserRegistrationDto.RequestDto
    ): ResponseEntity<UserRegistrationDto.ResponseDto> {
        return ResponseEntity
            .ok(userInformationService.registerUserInfo(userInfo))
    }

    @GetMapping("private-info/{userKey}")
    @ApiOperation(value = "유저 정보 조회", notes = "유저 정보를 조회하는 API")
    @ApiImplicitParam(name = "userKey", value = "유저 키")
    fun registerUser(
        @PathVariable userKey: String
    ): ResponseEntity<UserInformationDto.ResponseDto> {
        return ResponseEntity
            .ok(userInformationService.inquireUserInfo(userKey))
    }
}