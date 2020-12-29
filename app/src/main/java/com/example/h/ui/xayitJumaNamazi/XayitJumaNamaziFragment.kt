package com.example.h.ui.xayitJumaNamazi

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

class XayitJumaNamaziFragment : Fragment(R.layout.fragment_shahada), XayitJumaNamaziView {

    private lateinit var presenter: XayitJumaNamaziPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = XayitJumaNamaziPresenter(dao,this)
        presenter.getAllXayitJumaNamazi(7)
        (requireActivity() as MainActivity).supportActionBar?.title = "Ҳайыт ҳәм жума намазлары"
    }

    override fun setAllXayitJumaNamazi(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }
    }
}