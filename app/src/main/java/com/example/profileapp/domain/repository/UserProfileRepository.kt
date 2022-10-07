package com.example.profileapp.domain.repository

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    suspend fun getUserProfile(): Flow<Resource<UserProfile>>
}