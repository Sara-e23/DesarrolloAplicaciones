package com.example.proyecto1.network

//import com.example.proyecto1.Data.Model.AccountModel
//import com.example.proyecto1.Data.Model.UserModel
//import retrofit2.http.POST
//import com.google.gson.JsonObject
//import retrofit2.Response
//import retrofit2.http.Body
//import retrofit2.http.GET
//import retrofit2.http.Path
//
//interface ApiService {
//    @POST("user")//json object
//    suspend fun login(@Body username: UserModel): retrofit2.Response<JsonObject>
//
//    @GET("Service")//account list
//    suspend fun getAccounts():Response<List<AccountModel>>
//
//    @GET("service/{id}")//un elemento id
//    suspend fun getAccount(@Path("id") id: Int): Response<AccountModel>
//
//    @POST("Service")
//    suspend fun addAccount(@Body service: AccountModel):
//            Response<JsonObject>
//}