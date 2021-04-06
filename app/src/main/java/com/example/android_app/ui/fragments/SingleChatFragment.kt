package com.example.android_app.ui.fragments

import android.view.View
import com.example.android_app.R
import com.example.android_app.models.CommonModel
import com.example.android_app.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.view.*


class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.GONE
    }
}