package com.example.profileapp.presentation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profileapp.data.model.Resource
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.domain.usecase.GetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModel(){

    private var _userDetailsResponse = MutableLiveData<Resource<UserProfile>>()
    val userDetailsResponse: LiveData<Resource<UserProfile>> get() = _userDetailsResponse



    init {
        viewModelScope.launch(Dispatchers.IO) {
           getUserProfileUseCase.execute(Unit).collect{
               _userDetailsResponse.postValue(it)
           }
        }
    }


}