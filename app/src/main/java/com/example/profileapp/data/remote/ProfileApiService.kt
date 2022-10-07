package com.example.profileapp.data.remote

import com.example.profileapp.data.model.UserProfile
import retrofit2.http.GET

interface ProfileApiService {
    @GET()
    suspend fun getRandomProfile() : UserProfile

}