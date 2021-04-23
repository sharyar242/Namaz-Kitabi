package uz.texnopos.namaz.ui.paklik

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
import kotlinx.android.synthetic.main.fragment_paklik.*
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.core.dp
import uz.texnopos.namaz.data.NamazDatabase
import uz.texnopos.namaz.data.model.Article

class ArticleFragment: Fragment(R.layout.fragment_paklik) , PaklikView{

    private lateinit var presenter : PaklikPresenter
    private var textList = mutableListOf<TextView>()


    private val safeArgs: ArticleFragmentArgs by navArgs()
    private var type: Int = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        type = safeArgs.type


        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        presenter = PaklikPresenter(dao, this)
        presenter.getPaklikArticle(13)
        (requireActivity() as MainActivity).supportActionBar?.title = "Биз хаққымизда"

    }
    override fun setPaklikArticle(article: Article) {
        createDynamicViews(article)
    }

        private fun createDynamicViews(article: Article) {
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
                linearLayout.addView(textView)
            }
            if (imagePair[i].first < imagePair[i].second) {
                val imageView = ImageView(requireContext())
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(getWidth()-32.dp, ((getWidth()-32.dp)*1.52).toInt())
                params.setMargins(16.dp, 16.dp, 16.dp, 16.dp)
                imageView.layoutParams = params
                val id = resources.getIdentifier(string.substring(imagePair[i].first, imagePair[i].second), "drawable", requireContext().packageName)
                imageView.setBackgroundResource(id)
                linearLayout.addView(imageView)
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
            linearLayout.addView(textView)
        }

    }

    private fun getWidth() : Int {
        val display = Resources.getSystem().displayMetrics
        return display.widthPixels
    }
}