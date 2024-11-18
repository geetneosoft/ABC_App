package com.app.abc.domain.usecase

import com.app.abc.data.error_handling.ResponseHandler
import com.app.abc.data.repository.NewsRepository
import javax.inject.Inject

class GetHealthHeadlinesUseCase@Inject constructor(
    private val repository: NewsRepository,
) {
    suspend fun execute(): ResponseHandler {
        return repository.getHealth()
    }
}