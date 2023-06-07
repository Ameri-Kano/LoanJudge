package com.amerikano.api.test

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/loanjudge/api/v1")
class TestController(
    private val testService: TestService
) {

    @GetMapping("/test/get/{userKey}")
    fun test(
        @PathVariable userKey: String
    ): TestDto.UserInfoDto = testService.testGetService(userKey)
}