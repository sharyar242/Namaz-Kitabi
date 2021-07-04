package uz.texnopos.namaz.ui.namaz

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
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.core.dp
import uz.texnopos.namaz.data.NamazDatabase
import kotlinx.android.synthetic.main.fragment_namaz.*
import uz.texnopos.namaz.data.model.Namaz

class NamazFragment(): Fragment(R.layout.fragment_namaz),
        NamazView {

    private lateinit var presenter : NamazPresenter
    private var textList = mutableListOf<TextView>()
    private val safeArgs: NamazFragmentArgs by navArgs()
    private var namazId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        namazId = safeArgs.namaz
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = NamazPresenter(dao, this)
        presenter.getAllNamaz(namazId)
        allNamaz()
    }

    private fun allNamaz() {
        (requireActivity() as MainActivity).supportActionBar?.title =
            when (namazId) {
                1 -> "Намаз"
                2 -> "Азан, азан дуўасы, тәкбир"
                3 -> "Таң намаз"
                4 -> "Песин намаз"
                5 -> "Намазлыгер"
                6 -> "Шам намаз"
                7 -> "Қуптан ҳәм ўитр намазы"
                8 -> "ТАҲИЯТУЛ МАСЖИД"
                9 -> "ТӘҲӘЖЖУД НАМАЗЫ"
                10 -> "ҲАЙЫТ НАМАЗЫ"
                11 -> "ЖУМА НАМАЗЫ"
                12 -> "ЖАНАЗА НАМАЗЫ"
                13 -> "МҮСӘПИР АДАМНЫҢ НАМАЗЫ"
                14 -> "ИМАМҒА ЕРИЎ"
                15 -> "ҚАЗА НАМАЗ"
                16 -> "Намаздан кейинги зикирлер"
                17 -> "Намаз бузылатуғын жағдайлар"
                else -> "Null"
            }
    }


    override fun setNamaz(article: Namaz) {
        createDynamicViewsNamaz(article)
    }


    private fun createDynamicViewsNamaz(article: Namaz) {
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
                params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
                textView.layoutParams = params
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second), Html.FROM_HTML_MODE_COMPACT)
                } else {
                    textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second))
                }
                linearLayoutNamaz.addView(textView)
            }
            if (imagePair[i].first < imagePair[i].second) {
                val imageView = ImageView(requireContext())
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(getWidth()-32.dp, ((getWidth()-32.dp)*1.52/2).toInt())
                params.setMargins(16.dp, 16.dp,  16.dp, 0)
                imageView.layoutParams = params
                val id = resources.getIdentifier(string.substring(imagePair[i].first, imagePair[i].second), "drawable", requireContext().packageName)
                imageView.setBackgroundResource(id)
                linearLayoutNamaz.addView(imageView)
            }
        }
        val i = textPair.size-1
        if (textPair[i].first < textPair[i].second) {
            val textView = TextView(requireContext())
            textView.setTextColor(Color.BLACK)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
            textView.layoutParams = params
            textList.add(textView)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second), Html.FROM_HTML_MODE_COMPACT)
            } else {
                textView.text = Html.fromHtml(string.substring(textPair[i].first, textPair[i].second))
            }
            linearLayoutNamaz.addView(textView)
        }

    }


    private fun getWidth() : Int {
        val display = Resources.getSystem().displayMetrics
        return display.widthPixels
    }
}