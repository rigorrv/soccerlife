package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mvvm.data.RetrofitConnection
import com.github.mvvm.ui.model.GameWaiting
import com.github.mvvm.ui.model.LoginPojo
import com.github.mvvm.ui.model.RegisterPojo

class MyViewModel : ViewModel(){
    //variables
    val TAG : String = "TAG"
    val retrofitConnection = RetrofitConnection()
    //mutable LiveData
    //lo hacemos privado por que en en kotlin solo ocupamos poner MyViewModel.listData y accedemos a esta variable
    //pero si lo ponemos privado no podremos hacerlo
    private val listDataLogin = MutableLiveData<List<LoginPojo>>()
    private val listDataRegister = MutableLiveData<List<RegisterPojo>>()



    /**
     *con esta funcion lo que hacemos es que le generamos un parametro llamado listFrutas que es de tipo List<Frutas>
     * el cual una ves recibido se lo agregaremos como valor a listData
     */
    fun setListLoginData (ListLogin : List<LoginPojo>){
        listDataLogin.value = ListLogin
    }
    fun setListRegisterData (ListLogin : List<RegisterPojo>){
        listDataRegister.value = ListLogin
    }

    fun loginApp(email : String, pass : String){
        retrofitConnection.loginConnection(email, pass) {loginResults->
            //dataLogin = loginResults
            setListLoginData(loginResults)
        }
    }
    fun registerApp(name : String, last : String, email : String, passone :String, passtwo : String){
        retrofitConnection.registerNewUser(name, last, email, passone, passtwo) {registerResults->
            //dataLogin = loginResults
            setListRegisterData(registerResults)
        }
    }

    //livedata Login
    fun getListaLoginLiveData() : LiveData <List<LoginPojo>>{
        return listDataLogin
    }
    //livedata Register
    fun getListaRegisterLiveData() : LiveData <List<RegisterPojo>>{
        return listDataRegister
    }
}