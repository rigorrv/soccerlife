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


class MainFragment : Fragment() {

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

        rootView = inflater.inflate(R.layout.main_fragment, container, false) as ViewGroup
        communicator = activity as Communicator


        return rootView

    }







}