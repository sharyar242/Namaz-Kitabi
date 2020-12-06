package com.example.h.ui.shahada

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.h.R

class ShahadaFragment : Fragment() {

    private lateinit var shahadaViewModel: ShahadaViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shahadaViewModel =
            ViewModelProviders.of(this).get(ShahadaViewModel::class.java)
        return inflater.inflate(R.layout.fragment_shahada, container, false)
    }

}