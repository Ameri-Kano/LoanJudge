package com.amerikano.domain.converter

import com.amerikano.domain.enum.Product
import com.amerikano.domain.enum.findProductCode
import javax.persistence.AttributeConverter

class ProductConverter : AttributeConverter<Product, String> {
    override fun convertToDatabaseColumn(product: Product?)
        = product?.productCode ?: throw RuntimeException("no such code")

    override fun convertToEntityAttribute(name: String)
        = findProductCode(name)
}