package com.example.android_app.ui.fragments

import androidx.fragment.app.Fragment
import com.example.android_app.R
import com.example.android_app.utilits.APP_ACTIVITY


class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Telegram"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}