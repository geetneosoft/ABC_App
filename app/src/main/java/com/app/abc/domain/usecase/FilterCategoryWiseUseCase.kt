package com.app.abc.domain.usecase

import com.app.abc.data.error_handling.ResponseHandler
import com.app.abc.data.model.Article
import com.app.abc.data.model.News
import com.app.abc.domain.model.Category
import com.app.abc.domain.model.Filter
import javax.inject.Inject

class FilterCategoryWiseUseCase @Inject constructor(
    private val getBusinessUseCase: GetBusinessUseCase,
    private val getSportsHeadlinesUseCase: GetSportsHeadlinesUseCase,
    private val getHealthHeadlinesUseCase: GetHealthHeadlinesUseCase,
    private val getTechnologyUseCase: GetTechnologyUseCase
) {
    suspend fun execute(filter: Filter): ResponseHandler {
        val response =  when(filter.category){
            Category.Business-> getBusinessUseCase.execute()
            Category.Health-> getHealthHeadlinesUseCase.execute()
            Category.Sports-> getSportsHeadlinesUseCase.execute()
            Category.Technology-> getTechnologyUseCase.execute()
        }
        return when(response){
            is ResponseHandler.Success<*>->{
                val transformData: List<Article> = if(response.data is News){
                    response.data.articles.filter { item ->
                        item.title.contains(filter.query, ignoreCase = true)
                    }
                }else {
                    emptyList()
                }
                ResponseHandler.Success(News(transformData))
            }
            is ResponseHandler.Error<Throwable>->{
                ResponseHandler.Error(response.error)
            }
        }
    }
}