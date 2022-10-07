package com.example.profileapp.domain.base

abstract class BaseUseCase<in Params, out Response> {
    abstract suspend fun execute(params: Params): Response
}