package com.github.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.github.mvvm.R
import com.squareup.picasso.Picasso
class GoogleMapFragment : Fragment() {

    var inputText: String? = ""
    var inputImage: String? = ""
    var inputSong: String? = ""
    var trackTime: String? = ""
    var tittleBand: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.googlemap_view, container, false)
        inputText = arguments?.getString("inputText")
        inputImage = arguments?.getString("inputImage")
        inputSong = arguments?.getString("inputSong")
        trackTime = arguments?.getString("trackTime")
        tittleBand = arguments?.getString("tittleBand")




        return rootView
    }

}