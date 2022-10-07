package com.example.profileapp.util

import org.junit.Assert.*
import org.junit.Test

class LoginValidationTest{

    private  var email = "okezi002@gmail.com"
    private  var email2 = "okeh.josep@ymail.com"
    private  var email3 = "okezigmail.com"
    private  var email4 = "okezicom"

    private  var password = "okez4"
    private  var password1 = ""
    private  var password2 = "okezic"
    private  var password3 = "okezicom"


    @Test
    fun `return true if the email pattern is right`(){
        assertTrue(LoginValidation.verifyEmail(email))
        assertTrue(LoginValidation.verifyEmail(email2))
    }

    @Test
    fun `return false if the email pattern is right`(){
        assertFalse(LoginValidation.verifyEmail(email3))
        assertFalse(LoginValidation.verifyEmail(email4))
    }

    @Test
    fun `return true if the password length is 6 or more`(){
        assertTrue(LoginValidation.verifyPassword(password3))
        assertTrue(LoginValidation.verifyPassword(password2))
    }

    @Test
    fun `return false if the password length is less than 6 `(){
        assertFalse(LoginValidation.verifyPassword(password))
        assertFalse(LoginValidation.verifyPassword(password1))
    }
}