package com.example.android_app.ui.screens

import androidx.fragment.app.Fragment
import com.example.android_app.utilits.APP_ACTIVITY


open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }
}