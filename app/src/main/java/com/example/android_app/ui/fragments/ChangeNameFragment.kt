package com.example.android_app.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.android_app.MainActivity
import com.example.android_app.R
import com.example.android_app.utilits.*
import kotlinx.android.synthetic.main.fragment_change_name.*


class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        initFullnameList()
    }

    private fun initFullnameList() {
        val fullname_list = USER.fullname.split(" ")
        if (fullname_list.size > 1) {
            settings_input_name.setText(fullname_list[0])
            settings_input_surname.setText(fullname_list[1])
        } else settings_input_name.setText(fullname_list[0])
    }

    override fun change() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast(getString(R.string.settings_toast_name_is_empty))
        } else {
            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(getString(R.string.toast_data_updated))
                        USER.fullname = fullname
                        fragmentManager?.popBackStack()
                    }
                }
        }
    }
}