package uz.texnopos.namaz.ui.about

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.fragment.app.Fragment
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.Settings
import uz.texnopos.namaz.data.NamazDatabase
import uz.texnopos.namaz.data.model.Article
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment: Fragment(R.layout.fragment_about),
    AboutView{

    private lateinit var presenter : AboutPresenter
    private lateinit var settings: Settings


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        settings = Settings(requireContext())
        presenter = AboutPresenter(dao, this)
        presenter.getAllArticle(4)
        (requireActivity() as MainActivity).supportActionBar?.title = "Биз хаққымизда"
    }

    override fun setAboutArticle(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textAbout.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
            textAbout.textSize = settings.getTextSize()
        } else {
            textAbout.text = Html.fromHtml(article.article)
            textAbout.textSize = settings.getTextSize()
        }
    }



}