package com.example.h.ui.paklik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.h.R

class PaklikFragment : Fragment() {

    private lateinit var paklikViewModel: PaklikViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paklikViewModel =
                ViewModelProviders.of(this).get(PaklikViewModel::class.java)
        return inflater.inflate(R.layout.fragment_paklik, container, false)
    }
}