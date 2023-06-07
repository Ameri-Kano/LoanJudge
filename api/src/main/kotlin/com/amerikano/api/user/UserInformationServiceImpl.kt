package com.amerikano.api.user

import com.amerikano.api.common.CommonResponse
import com.amerikano.api.common.CommonResponseCode
import com.amerikano.api.loan.GenerateKey
import com.amerikano.api.loan.encrypt.EncryptComponent
import com.amerikano.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInformationServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
) : UserInformationService {
    override fun registerUserInfo(newUserInfoDto: UserRegistrationDto.RequestDto)
            : UserRegistrationDto.ResponseDto {
        val userKey = generateKey.generateUserKey()

        newUserInfoDto.userRegistrationNumber =
            encryptComponent.encryptString(newUserInfoDto.userRegistrationNumber)

        val userInfoDto = newUserInfoDto.toUserInfoDto(userKey)

        userInfoRepository.save(userInfoDto.toEntity())

        val okResponse = CommonResponse(CommonResponseCode.SUCCESS).toResponseDto()

        return UserRegistrationDto.ResponseDto(
            UserRegistrationDto.UserKey(userKey),
            okResponse.responseCode,
            okResponse.responseMessage
        )
    }

    override fun inquireUserInfo(userKey: String)
    : UserInformationDto.ResponseDto {
        val userInfo = userInfoRepository.findByUserKey(userKey)
        val decryptedNumber = encryptComponent.decryptString(userInfo.userRegistrationNumber)

        val okResponse = CommonResponse(CommonResponseCode.SUCCESS).toResponseDto()

        return UserInformationDto.ResponseDto(
            UserInformationDto.KeyAndNumber(
                userKey, decryptedNumber
            ),
            responseCode = okResponse.responseCode,
            responseMessage = okResponse.responseMessage
        )
    }
}