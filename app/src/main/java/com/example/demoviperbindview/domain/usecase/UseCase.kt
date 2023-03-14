package com.example.demoviperbindview.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<out Type, in Params> constructor(private val coroutineDispatcher: CoroutineDispatcher) where Type : Any {

    abstract suspend fun execute(params: Params): Type

    suspend operator fun invoke(
        params: Params
    ): Type = withContext(coroutineDispatcher) {
        execute(params)
    }

    class None
}