package com.example.bookapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class WelcomeFragment : Fragment() {
    private lateinit var progressAnnimator : ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        Handler().postDelayed({
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_blankFragment)
        },2000)
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var progress : ProgressBar? = view?.findViewById(R.id.progressBar3)
        progressAnnimator = ObjectAnimator.ofInt(progress,"progress",200,1000)
        progressAnnimator.setDuration(2000)
        progressAnnimator.start()
    }




}