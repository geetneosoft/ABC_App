package com.app.abc.data.repository

import com.app.abc.data.error_handling.ResponseHandler
import com.app.abc.data.model.News
import com.app.abc.data.producer.DataSource
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val dataSource : DataSource
): NewsRepository {


    override suspend fun getBusiness(): ResponseHandler {

        return try{
            val data = News(dataSource.businessList)
            ResponseHandler.Success(data)
        }catch(e:Exception){
            ResponseHandler.Error(e)
        }
    }

    override suspend fun getSports(): ResponseHandler {
        return try{
            val data = News(dataSource.sportList)
            ResponseHandler.Success(data)
        }catch(e:Exception){
            ResponseHandler.Error(e)
        }
    }

    override suspend fun getHealth(): ResponseHandler {
        return try{
            val data = News(dataSource.healthList)
            ResponseHandler.Success(data)
        }catch(e:Exception){
            ResponseHandler.Error(e)
        }
    }

    override suspend fun getTechnology(): ResponseHandler {
        return try{
            val data = News(dataSource.technologyList)
            ResponseHandler.Success(data)
        }catch(e:Exception){
            ResponseHandler.Error(e)
        }
    }

}