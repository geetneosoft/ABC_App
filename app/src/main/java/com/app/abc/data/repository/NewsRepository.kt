package com.app.abc.data.repository

import com.app.abc.data.error_handling.ResponseHandler


interface NewsRepository{

    suspend fun getBusiness() : ResponseHandler

    suspend fun getSports() : ResponseHandler

    suspend fun getTechnology() : ResponseHandler

    suspend fun getHealth() : ResponseHandler
}