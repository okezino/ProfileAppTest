package com.example.profileapp.domain.base

open class BaseRepositoryService {
    suspend fun <T> executeRequest(request: suspend () -> T): T {
        return request()
    }
}