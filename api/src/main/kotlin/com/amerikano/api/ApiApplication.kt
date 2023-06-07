package com.amerikano.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(basePackages = ["com.amerikano.domain"])
@ComponentScan(basePackages = ["com.amerikano"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}