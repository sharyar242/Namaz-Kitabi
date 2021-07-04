package uz.texnopos.namaz.ui.sureler

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
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_namaz.*
import kotlinx.android.synthetic.main.fragment_paklik.*
import kotlinx.android.synthetic.main.fragment_sureler.*
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.core.dp
import uz.texnopos.namaz.data.NamazDatabase
import uz.texnopos.namaz.data.model.Namaz
import uz.texnopos.namaz.data.model.Sureler

class SurelerFragment(): Fragment(R.layout.fragment_sureler),
    SurelerView {

    private lateinit var presenter : SurelerPresenter
    private var textList = mutableListOf<TextView>()
    private val safeArgs: SurelerFragmentArgs by navArgs()
    private var index: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    index = safeArgs.id
    val dao = NamazDatabase.getInstance(requireContext()).articleDao()
    presenter = SurelerPresenter(dao, this)
    presenter.getSurelerArticle(index)
    allSureler()
    }

    private fun allSureler() {
        (requireActivity() as MainActivity).supportActionBar?.title =
            when (index) {
                1 -> "«Фатиҳа» сүреси"
                2 -> "«Фийл» сүреси"
                3 -> "«Қурайш» сүреси"
                4 -> "«Маъуўн» сүреси"
                5 -> "«Кәусар» сүреси"
                6 -> "«Кәфируўн» суреси"
                7 -> "«Наср» сүреси"
                8 -> "«Мəсад» сүреси"
                9 -> "«Ыхлас» сүреси"
                10 -> "«Фәлақ» сүреси"
                11 -> "«Нәс» сүреси"
                else -> "Null"
            }
    }


    private fun createDynamicViewsSureler(article: Sureler) {
        //////////////Qay jerde text qay jerde suwret ekenin tawip aliw//////////////////
        val textPair: MutableList<Pair<Int, Int>> = mutableListOf()
        val imagePair: MutableList<Pair<Int, Int>> = mutableListOf()
        var string = article.article
        var i1 = string.indexOf('{')
        var i2 = -1
        while (i1 != -1) {
            textPair.add(Pair(i2+1, i1-1))
            i2 = string.indexOf('}')
            val chars = string.toCharArray()
            chars[i1] = '*'
            chars[i2] = '*'
            string = String(chars)
            imagePair.add(Pair(i1+1, i2))
            i1 = string.indexOf('{')
        }
        textPair.add(Pair(i2+1, string.length-1))
        /////////////////////////////////////////////////////////////////////////////////
        for (i in 0 until textPair.size-1) {
            if (textPair[i].first < textPair[i].second) {
                val textView = TextView(requireContext())
                textList.add(textView)
                textView.setTextColor(Color.BLACK)
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(16.dp, 0.dp, 0.dp, 16.dp)
                textView.layoutParams = params
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second), Html.FROM_HTML_MODE_COMPACT)
                } else {
                    textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second))
                }
                linearLayoutSureler.addView(textView)
            }
            if (imagePair[i].first < imagePair[i].second) {
                val imageView = ImageView(requireContext())
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(getWidth()-32.dp, ((getWidth()-32.dp)*1.52/2).toInt())
                params.setMargins(16.dp, 16.dp,  16.dp, 0)
                imageView.layoutParams = params
                val id = resources.getIdentifier(string.substring(imagePair[i].first, imagePair[i].second), "drawable", requireContext().packageName)
                imageView.setBackgroundResource(id)
                linearLayoutSureler.addView(imageView)
            }
        }
        val i = textPair.size-1
        if (textPair[i].first < textPair[i].second) {
            val textView = TextView(requireContext())
            textView.setTextColor(Color.BLACK)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(16.dp, 16.dp, 0.dp, 16.dp)
            textView.layoutParams = params
            textList.add(textView)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second), Html.FROM_HTML_MODE_COMPACT)
            } else {
                textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second))
            }
            linearLayoutSureler.addView(textView)
        }

    }

    private fun getWidth() : Int {
        val display = Resources.getSystem().displayMetrics
        return display.widthPixels
    }

    override fun setSureler(article: Sureler) {
        createDynamicViewsSureler(article)
    }
}