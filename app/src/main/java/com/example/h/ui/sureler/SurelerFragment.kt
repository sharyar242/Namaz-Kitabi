package com.example.h.ui.sureler

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

class SurelerFragment: Fragment(R.layout.fragment_shahada),SurelerView {

    private lateinit var presenter: SurelerPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = SurelerPresenter(dao,this)
        presenter.getAllSureler(11)
        (requireActivity() as MainActivity).supportActionBar?.title = "Қысқа сүрелер"
    }

    override fun setAllSureler(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }
    }


}