package com.example.h.ui.dualar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.h.R
import com.example.h.ui.namaz.NamazViewModel

class DualarFragment: Fragment() {


    private lateinit var dualarViewModel: NamazViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dualarViewModel =
            ViewModelProviders.of(this).get(NamazViewModel::class.java)
        return inflater.inflate(R.layout.fragment_namaz, container, false)
    }
}