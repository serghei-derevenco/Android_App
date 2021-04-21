package com.example.android_app.ui.fragments.message_recycler_view.views

import com.example.android_app.models.CommonModel
import com.example.android_app.utilits.TYPE_MESSAGE_IMAGE


class AppViewFactory {
    companion object {
        fun getView(message: CommonModel): MessageView {
            return when(message.type) {
                TYPE_MESSAGE_IMAGE -> ViewImageMessage(
                    message.id,
                    message.from,
                    message.timeStamp.toString(),
                    message.fileUrl
                )
                else -> ViewTextMessage(
                    message.id,
                    message.from,
                    message.timeStamp.toString(),
                    message.fileUrl,
                    message.text
                )
            }
        }
    }
}