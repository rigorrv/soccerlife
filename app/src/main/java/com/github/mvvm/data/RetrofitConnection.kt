package com.github.mvvm.data

import android.util.Log
import com.github.mvvm.ui.model.ApiLogin
import com.github.mvvm.ui.model.GameWaiting
import com.github.mvvm.ui.model.LoginPojo
import com.github.mvvm.ui.model.RegisterPojo
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection() {


    //register new user
    fun registerNewUser(name: String, last: String, email :String, passone : String, passtwo : String, callback: (registerResults: List<RegisterPojo>) -> Unit) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nonstopcode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiLogin::class.java)

        api.registerUser(name, last, email, passone, passtwo).enqueue(object : Callback<List<RegisterPojo>> {
            override fun onFailure(call: Call<List<RegisterPojo>>, t: Throwable) {
                Log.d("TAG", "Error Register: ${t.message}")


            }

            override fun onResponse(
                call: Call<List<RegisterPojo>>,
                response: Response<List<RegisterPojo>>
            ) {
                //Log.d("Data Register", "Working" + GsonBuilder().setPrettyPrinting().create().toJson(response.body()))

                callback.invoke(response.body()!!)
            }


        })

    }

    //Login
    fun loginConnection(email: String, pass: String, callback: (loginResults: List<LoginPojo>) -> Unit) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nonstopcode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiLogin::class.java)

        api.loginPostTournament(email, pass).enqueue(object : Callback<List<LoginPojo>> {
            override fun onFailure(call: Call<List<LoginPojo>>, t: Throwable) {
                //Log.d("TAG", "Error Login: ${t.message}")
            }

            override fun onResponse(
                call: Call<List<LoginPojo>>,
                response: Response<List<LoginPojo>>
            ) {
                Log.d("Data Login", "Working" + GsonBuilder().setPrettyPrinting().create().toJson(response.body()))

                callback.invoke(response.body()!!)
            }


        })

    }


    //Checking Game Match
    fun checkingMatch(email: String, pass: String, callback: (chekingMatch: List<GameWaiting>) -> Unit) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://nonstopcode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiLogin::class.java)

        api.checkingMatch(email, pass).enqueue(object : Callback<List<GameWaiting>> {
            override fun onFailure(call: Call<List<GameWaiting>>, t: Throwable) {
                Log.d("TAG", "Error Checking match: ${t.message}")


            }

            override fun onResponse(
                call: Call<List<GameWaiting>>,
                response: Response<List<GameWaiting>>
            ) {
                Log.d("Data Match", "Working" + GsonBuilder().setPrettyPrinting().create().toJson(response.body()))

                callback.invoke(response.body()!!)
            }


        })

    }

}