package com.amerikano.domain.repository

import com.amerikano.domain.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository: JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String): UserInfo
}