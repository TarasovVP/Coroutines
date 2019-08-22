package com.vptarasov.coroutines

class GetListOfPostsUseCase
    : BaseUseCase<GetListOfPostsUseCase.Params, GetListOfPostsUseCase.Result>() {

    override suspend fun doWork(params: Params): Result {
        return Result(
            PostsRepository()
                .doWork(PostsRepository.Params())
                .posts

        )
    }

    class Params
    class Result(val posts: List<Post>?)
}