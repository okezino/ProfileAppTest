package com.example.profileapp.domain.usecase

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.domain.base.BaseUseCase
import com.example.profileapp.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(private val userProfileRepository: UserProfileRepository) :
    BaseUseCase<
            Unit, Flow<Resource<UserProfile>>>() {

    override suspend fun execute(params: Unit): Flow<Resource<UserProfile>> {
        return userProfileRepository.getUserProfile()
    }
}