package com.amerikano.domain.converter

import com.amerikano.domain.enum.Organization
import com.amerikano.domain.enum.findOrganizationCode
import org.springframework.stereotype.Component
import javax.persistence.AttributeConverter

@Component
class OrganizationConverter : AttributeConverter<Organization, String> {
    override fun convertToDatabaseColumn(organization: Organization?)
        = organization?.organizationCode ?: throw RuntimeException("code not exist")

    override fun convertToEntityAttribute(name: String)
        = findOrganizationCode(name)
}