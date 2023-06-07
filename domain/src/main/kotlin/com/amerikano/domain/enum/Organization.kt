package com.amerikano.domain.enum

enum class Organization(
    val organizationCode: String
) {
    ORGANIZATION_A("00001"),
    ORGANIZATION_B("00002"),
    ORGANIZATION_C("00003");
}

fun findOrganizationCode(organizationCode: String): Organization {
    return Organization.values()
        .find { o ->
            o.organizationCode == organizationCode
        } ?: throw RuntimeException("no such type")

}