package com.example.h.ui.namaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.h.R

class NamazFragment : Fragment() {

    private lateinit var namazViewModel: NamazViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
           namazViewModel =
                ViewModelProviders.of(this).get(NamazViewModel::class.java)
        return inflater.inflate(R.layout.fragment_namaz, container, false)
    }
}