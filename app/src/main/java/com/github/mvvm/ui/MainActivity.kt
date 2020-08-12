package com.github.mvvm.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.viewmodel.MyViewModel
import com.github.mvvm.R
import com.github.mvvm.ui.model.Communicator
import com.github.mvvm.ui.model.GameWaiting
import com.github.mvvm.ui.model.LoginPojo
import com.github.mvvm.ui.model.RegisterPojo
import kotlinx.android.synthetic.main.login_fragment.*

class MainActivity : AppCompatActivity() , Communicator {

    val TAG : String = "TAG"
    private lateinit var viewModel : MyViewModel
    val loginFragment = LoginFragment()
    val mainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.myFragments, loginFragment)
            .commit()


    }


    //observables for Login
    override fun loginData(username : String, password : String) {
        val bundle = Bundle()
        bundle.putString("inputText", username)
        bundle.putString("inputImage", password)
        viewModel= ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.loginApp(username,password)

        val loginObserver = Observer<List<LoginPojo>>{
            if (!it.isEmpty()){
                loginBox.visibility = View.GONE
                supportFragmentManager.beginTransaction().replace(R.id.myFragments, mainFragment)
                    .commit()
            }else{
                Log.d(TAG, "loginData: Error in the login")
                errorMsg.setText("Error in the login try again")
            }
            for (login in it) {
                //Log.d("Your email", login.email)
                //Log.d("Your email", login.name)

            }
            for ((index : Int, value : LoginPojo) in it.withIndex()){
                //Log.d("user $index", value.pass)
            }
        }
        viewModel.getListaLoginLiveData().observe(this,loginObserver)
        Log.d(TAG, "passData: $username, $password")
    }

    override fun registerData(name: String, last: String, email: String, passone : String, passtwo : String  ) {
        val bundle = Bundle()
        bundle.putString("nameregister", name)
        bundle.putString("lastregister", last)
        bundle.putString("emailregister", email)
        bundle.putString("passoneregister", passone)
        bundle.putString("passoneregister", passtwo)

        viewModel= ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.registerApp(name,last, email, passone, passtwo)
        val loginObserver = Observer<List<RegisterPojo>>{
            it ?: null
            loginBox.visibility = View.GONE
            for (register in it) {
                Log.d("name", register.email)
                Log.d("lastname", register.email)
                Log.d("email", register.email)
            }
            for ((index : Int, value : RegisterPojo) in it.withIndex()){
                //Log.d("user $index", value.pass)
            }
        }
        viewModel.getListaRegisterLiveData().observe(this,loginObserver)
        Log.d(TAG, "passData: $name, $last, $email, $passone, $passtwo")
    }
}