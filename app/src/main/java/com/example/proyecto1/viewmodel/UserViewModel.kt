package com.example.proyecto1.viewmodel

import com.example.proyecto1.Data.Model.UserModel
//import com.example.proyecto1.network.RetrofitClient
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    /*
    val api = RetrofitClient.api
    //the question mark indicates that the function may receive a JsonObject or may not
    //the lack of it could result in the program having critical problems for not receiving the expected
    //object
    fun loginAPI(user_model: UserModel, onResult: (JsonObject?) -> Unit){
        viewModelScope.launch{
            try {
                val response = api.login(user_model)
                if(response.isSuccessful){
                    val jsonResponse = response.body()
                    Log.d("debug", "${response.body()}" /* or jsonResponse.toString()*/)
                    onResult(jsonResponse)
                }else{
                    Log.d("debug", "ERROR: ${response.body()}")
                    onResult(null)
                }
            }catch (exception: Exception){
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(null)
            }
        }
    }

     */
}