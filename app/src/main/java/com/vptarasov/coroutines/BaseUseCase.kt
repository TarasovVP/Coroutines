package com.vptarasov.coroutines

abstract class BaseUseCase<Params, Result> {

    abstract suspend fun doWork(params: Params): Result

}