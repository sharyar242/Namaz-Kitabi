package com.example.h.ui.settings

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.fragment.app.Fragment
import com.example.h.MainActivity
import com.example.h.R
import com.example.h.Settings
import com.example.h.data.NamazDatabase
import com.example.h.data.model.Article
import com.example.h.ui.OnTextSizeChangeListener
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment: Fragment(R.layout.fragment_settings), SettingsView,
    OnTextSizeChangeListener{

    private lateinit var presenter: SettingsPresenter
    private lateinit var settings: Settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = NamazDatabase.getInstance(requireContext()).articleDao()
        settings = Settings(requireContext())
        presenter = SettingsPresenter(dao,this)
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
            settings.changeAppMode()
            (requireActivity() as MainActivity).updateThemeAndRecreateActivity()
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