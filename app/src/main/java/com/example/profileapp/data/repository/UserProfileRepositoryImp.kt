package com.example.profileapp.data.repository

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.data.remote.ProfileApiService
import com.example.profileapp.domain.base.BaseRepositoryService
import com.example.profileapp.domain.repository.UserProfileRepository
import com.example.profileapp.util.ApiCallsHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserProfileRepositoryImp @Inject constructor(val profileApiService : ProfileApiService) :
    UserProfileRepository, BaseRepositoryService() {
    override suspend fun getUserProfile(): Flow<Resource<UserProfile>>  = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(profileApiService.getRandomProfile()))
        }catch (exception : Exception){
            emit(Resource.Error(ApiCallsHandler.getError(exception)))
        }


    }
}