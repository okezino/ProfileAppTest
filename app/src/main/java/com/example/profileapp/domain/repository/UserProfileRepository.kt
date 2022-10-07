package com.example.profileapp.domain.repository

import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile

interface UserProfileRepository {
    suspend fun getUserProfile(): Resource<UserProfile>
}