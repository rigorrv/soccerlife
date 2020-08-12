package com.github.mvvm.ui.model

interface Communicator {
    //login
    fun loginData(username : String , password : String)
    //register
    fun registerData(name : String , last : String, email : String, passone :  String, passtwo : String)


}