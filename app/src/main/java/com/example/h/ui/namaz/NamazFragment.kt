package com.example.h.ui.namaz

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.fragment.app.Fragment
import com.example.h.MainActivity
import com.example.h.R
import com.example.h.data.NamazDatabase
import com.example.h.data.model.Article
import kotlinx.android.synthetic.main.fragment_shahada.*

class NamazFragment : Fragment(R.layout.fragment_shahada), NamazView {

    private lateinit var  presenter : NamazPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = NamazPresenter(dao,this)
        presenter.getAllNamaz(2)
        (requireActivity() as MainActivity).supportActionBar?.title = "Намаз оқыў тәртиплери"
    }

    override fun setAllNamaz(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }
    }

}