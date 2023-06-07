package com.amerikano.api.user

interface UserInformationService {
    fun registerUserInfo(newUserInfoDto: UserRegistrationDto.RequestDto)
            : UserRegistrationDto.ResponseDto

    fun inquireUserInfo(userKey: String)
            : UserInformationDto.ResponseDto
}