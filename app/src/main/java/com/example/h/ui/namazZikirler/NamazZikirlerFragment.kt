package com.example.h.ui.namazZikirler

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

class NamazZikirlerFragment : Fragment(R.layout.fragment_shahada), NamazZikirlerView {

    private lateinit var presenter: NamazZikirlerPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = NamazZikirlerPresenter(dao,this)
        presenter.getAllZikirlerView(3)
        (requireActivity() as MainActivity).supportActionBar?.title = "Намаздан кейинги зикирлер"
    }

    override fun setAllNamazZikirler(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textShahada.text = Html.fromHtml(article.article)
        }
    }


}