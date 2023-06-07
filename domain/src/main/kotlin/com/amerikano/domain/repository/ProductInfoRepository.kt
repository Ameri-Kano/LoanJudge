package com.amerikano.domain.repository

import com.amerikano.domain.domain.ProductInfo
import com.amerikano.domain.enum.Organization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInfoRepository: JpaRepository<ProductInfo, Long> {
    fun findAllByOrganizationCode(organizationCode: Organization): List<ProductInfo>
}