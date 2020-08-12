package com.github.mvvm.ui.model

import retrofit2.Call
import retrofit2.http.*


interface ApiLogin {


    //Login App
    @FormUrlEncoded
    //@GET("users/{user}/repos")
    @POST("/rigo/soccerproject/loginuserapp.php")
    fun loginPostTournament(
        @Field("email") email: String,
        @Field("pass") pass: String
        //@Field("apppost") apppost: String

    ): Call<List<LoginPojo>>

    //Login App
    @FormUrlEncoded
    //@GET("users/{user}/repos")
    @POST("/rigo/soccerproject/loginuserapp.php")
    fun checkingMatch(
        @Field("email") email: String,
        @Field("pass") pass: String
        //@Field("apppost") apppost: String

    ): Call<List<GameWaiting>>

    //Register App
    @FormUrlEncoded
    //@GET("users/{user}/repos")
    @POST("/rigo/soccerproject/registerUsaerApp.php")
    fun registerUser(

        @Field("name") name: String,
        @Field("last") last: String,
        @Field("email") email: String,
        @Field("pass") pass: String,
        @Field("passtwo") passtwo: String

    ): Call<List<RegisterPojo>>


}