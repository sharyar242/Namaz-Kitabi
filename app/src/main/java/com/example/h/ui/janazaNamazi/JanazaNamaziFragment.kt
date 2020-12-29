package com.example.h.ui.janazaNamazi

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

class JanazaNamaziFragment : Fragment(R.layout.fragment_shahada), JanazaNamaziView {

    private lateinit var presenter : JanazaNamaziPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = JanazaNamaziPresenter(dao,this)
        presenter.getAllJanazaNamazi(5)
        (requireActivity() as MainActivity).supportActionBar?.title = "Жаназа намазы тәртиби"
    }

    override fun setAllJanazaNamazi(article: Article){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }

    }
}