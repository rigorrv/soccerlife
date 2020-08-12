package com.github.mvvm.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.mvvm.R
import com.github.mvvm.ui.model.Communicator
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*


class LoginFragment : Fragment() {

    val TAG : String = "TAG"
    lateinit var communicator: Communicator
    lateinit var rootView: View


    lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.login_fragment, container, false) as ViewGroup
        communicator = activity as Communicator
        rootView.loginBox.visibility= View.VISIBLE
        rootView.registerBox.visibility= View.GONE
        rootView.errorMsg.setText("")

        // Click to login
        rootView.myLoginText.setOnClickListener {
            communicator.loginData(rootView.myUsernameEdit.text.toString(), rootView.mypassEdit.text.toString())
        }

        //click to open register box
        rootView.registerbtntx.setOnClickListener {
            Log.d(TAG, "onCreateView: you clicked")
            rootView.loginBox.visibility= View.GONE
            rootView.registerBox.visibility= View.VISIBLE
        }

        //click to register new user
        rootView.singUp.setOnClickListener {
            communicator.registerData(
                rootView.nameEdit.text.toString(),
                rootView.lastNameEdit.text.toString(),
                rootView.emailEdit.text.toString(),
                rootView.passwordEditRegister.text.toString(),
                rootView.passwordEditRegisterTwo.text.toString())
        }

        //click to open login box
        rootView.backLogin.setOnClickListener {
            Log.d(TAG, "onCreateView: you clicked")
            rootView.loginBox.visibility= View.VISIBLE
            rootView.registerBox.visibility= View.GONE
        }



        return rootView

    }







}