package com.example.h.ui.dualar

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


class DualarFragment: Fragment(R.layout.fragment_shahada), DualarView {

    private lateinit var presenter: DualarPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = DualarPresenter(dao,this)
        presenter.getAllDualar(8)
        (requireActivity() as MainActivity).supportActionBar?.title = "Жүдә зәрүр дуўалар"
    }
    override fun setAllDualar(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }
    }
}