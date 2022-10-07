package com.example.profileapp.presentation
import androidx.lifecycle.ViewModel
import com.example.profileapp.domain.usecase.GetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModel(){


}