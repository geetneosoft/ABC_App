package com.app.abc.data.error_handling

sealed class ResponseHandler {

    data class Success<out T>(val data : T?): ResponseHandler()
    data class Error<out T:Throwable>(val error : T?): ResponseHandler()
}