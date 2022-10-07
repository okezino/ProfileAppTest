package com.example.profileapp.util

object LoginValidation {

    fun verifyEmail(email : String) : Boolean{
        val regex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return email.matches(regex)
    }

    fun verifyPassword(password : String) : Boolean{
        return password.length > 5
    }
}