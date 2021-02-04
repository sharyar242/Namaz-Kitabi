package uz.texnopos.namaz.ui.settings

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.texnopos.namaz.MainActivity
import uz.texnopos.namaz.R
import uz.texnopos.namaz.Settings
import uz.texnopos.namaz.data.NamazDatabase
import uz.texnopos.namaz.data.model.Article
import uz.texnopos.namaz.ui.OnTextSizeChangeListener
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment: Fragment(R.layout.fragment_settings),
    SettingsView,
    OnTextSizeChangeListener {

    private lateinit var presenter: SettingsPresenter
    private lateinit var settings: Settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        settings = Settings(requireContext())
        presenter = SettingsPresenter(dao, this)
        presenter.getAllSettings(12)
        (requireActivity() as MainActivity).supportActionBar?.title = "Сазламалар"
        btnMinus.setOnClickListener {
            if (settings.getTextSize() > 12) {
                settings.decrementTextSize()
                onTextSizeChanged(settings.getTextSize())
            }
        }
        btnPlus.setOnClickListener {
            if (settings.getTextSize() < 32) {
                settings.incrementTextSize()
                onTextSizeChanged(settings.getTextSize())
            }
        }

        knopka.setOnCheckedChangeListener { _, _ ->
            if(knopka.isChecked) {
                Toast.makeText(
                    activity, "Жақын арада иске түседи!",
                    Toast.LENGTH_LONG
                ).show();
            }
//            settings.changeAppMode()
//            (requireActivity() as MainActivity).updateThemeAndRecreateActivity()
        }

    }

    override fun onTextSizeChanged(size: Float) {
        textShahada?.textSize = size
    }

    override fun setAllSettings(article: Article) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textShahada.text = Html.fromHtml(article.article, Html.FROM_HTML_MODE_COMPACT)
            textShahada.textSize = settings.getTextSize()
        } else {
            textShahada.text = Html.fromHtml(article.article)
            textShahada.textSize = settings.getTextSize()
        }
    }


}