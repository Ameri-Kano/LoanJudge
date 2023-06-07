package com.amerikano.domain.domain

import com.amerikano.domain.converter.OrganizationConverter
import com.amerikano.domain.converter.ProductConverter
import com.amerikano.domain.enum.Organization
import com.amerikano.domain.enum.Product
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_INFO")
class ProductInfo (

    @Convert(converter = OrganizationConverter::class)
    @Column(name = "org_cd")
    val organizationCode: Organization,

    @Convert(converter = ProductConverter::class)
    @Column(name = "prod_cd")
    val productCode: Product,

    @Column(name = "prod_nm")
    val productName: String,

    @Column(name = "prod_min_intr")
    val productMinimumInterest: Double,

    @Column(name = "prod_max_intr")
    val productMaximumInterest: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}