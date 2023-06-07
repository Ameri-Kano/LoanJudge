package com.amerikano.api.exception

class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException() {
}