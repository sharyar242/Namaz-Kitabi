package com.example.h.ui.settings

import com.example.h.data.model.Article

interface SettingsView {
    fun setAllSettings(article: Article)
}