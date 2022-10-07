package com.example.profileapp.util
import com.example.profileapp.data.model.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

object ApiCallsHandler {

    private const val MESSAGE_KEY = "message"
    private const val ERROR_KEY = "error"


    fun getErrorMessage(responseBody: ResponseBody): String {
        return try {
            val jsonObject = JSONObject(responseBody.string())
            when {
                jsonObject.has(MESSAGE_KEY) -> jsonObject.getString(MESSAGE_KEY)
                jsonObject.has(ERROR_KEY) -> jsonObject.getString(ERROR_KEY)
                else -> "Something wrong happened"
            }
        } catch (e: Exception) {
            "Something wrong happened"
        }
    }

    fun getError(exception: Exception) : String{
        val errorMessage: String = when (exception ) {
            is IOException -> {
                "IO Error! Could not Connect to the Internet"
            }
            is HttpException -> {
                val code = exception.code()
                val errorResponse = exception.response()?.errorBody()?.let {
                    ApiCallsHandler.getErrorMessage(it)
                }
                "Error $code -> $errorResponse"
            }
            else -> {
                "An error has occurred"
            }
        }
        return errorMessage
    }

}