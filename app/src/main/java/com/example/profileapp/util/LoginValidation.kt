package com.example.profileapp.util

import com.example.profileapp.data.model.LoginEvent

object LoginValidation {

    fun verifyEmail(email: String): Boolean {
        val regex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return email.matches(regex)
    }

    fun verifyPassword(password: String): Boolean {
        return password.length > 5
    }


    fun validateDetails(email: String, password: String): LoginEvent {
        return if (verifyEmail(email) && verifyPassword(password)) {
            LoginEvent.Success
        } else if (!verifyEmail(email)) {
            LoginEvent.Error("Invalid Email format")
        } else
            LoginEvent.Error("Invalid Password format")
    }
}




