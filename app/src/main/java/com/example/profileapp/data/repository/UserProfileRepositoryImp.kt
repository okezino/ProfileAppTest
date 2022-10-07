package com.example.profileapp.data.repository

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.data.remote.ProfileApiService
import com.example.profileapp.domain.base.BaseRepositoryService
import com.example.profileapp.domain.repository.UserProfileRepository
import javax.inject.Inject

class UserProfileRepositoryImp @Inject constructor(val profileApiService : ProfileApiService) :
    UserProfileRepository, BaseRepositoryService() {
    override suspend fun getUserProfile(): Resource<UserProfile> {
        TODO("Not yet implemented")
    }
}