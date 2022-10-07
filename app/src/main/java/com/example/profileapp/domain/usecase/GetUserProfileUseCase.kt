package com.example.profileapp.domain.usecase

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.domain.base.BaseUseCase
import com.example.profileapp.domain.repository.UserProfileRepository
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(private val userProfileRepository: UserProfileRepository) :
    BaseUseCase<
            String, GetUserProfileUseCase.Response>() {

    data class Response(
        val data: Resource<UserProfile>
    )

    override suspend fun execute(params: String): Response {
        return Response(userProfileRepository.getUserProfile())
    }
}