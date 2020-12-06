package com.example.h.ui.sureler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.h.R
import com.example.h.ui.namaz.NamazViewModel

class SurelerFragment: Fragment() {

    private lateinit var surelerViewModel: SurelerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        surelerViewModel =
            ViewModelProviders.of(this).get(SurelerViewModel::class.java)
        return inflater.inflate(R.layout.fragment_namaz, container, false)
    }
}