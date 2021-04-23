package uz.texnopos.namaz.ui.dualar

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_dualar.*
import kotlinx.android.synthetic.main.fragment_paklik.*
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.Settings
import uz.texnopos.namaz.core.dp
import uz.texnopos.namaz.data.NamazDatabase
import uz.texnopos.namaz.data.model.Article
import uz.texnopos.namaz.ui.about.AboutPresenter

class DualarFragment(): Fragment(R.layout.fragment_dualar) , DualarView {


    private lateinit var presenter : DualarPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = DualarPresenter(dao, this)
        presenter.getDualarArticle(13)
        (requireActivity() as MainActivity).supportActionBar?.title = "Биз хаққымизда"
    }
    override fun setDualarArticle(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textDualar.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textDualar.text = Html.fromHtml(article.article)
        }
    }




}