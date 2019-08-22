package com.vptarasov.coroutines

abstract class BaseRepository<Params, Result> {

    abstract suspend fun doWork(params: Params): Result

}