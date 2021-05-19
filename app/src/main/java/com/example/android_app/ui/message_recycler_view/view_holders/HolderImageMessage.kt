package com.example.android_app.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.android_app.database.CURRENT_UID
import com.example.android_app.ui.message_recycler_view.views.MessageView
import com.example.android_app.utilits.asTime
import com.example.android_app.utilits.downloadAndSetImage
import kotlinx.android.synthetic.main.message_item_image.view.*


class HolderImageMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {
    private val blocUserImageMessage: ConstraintLayout = view.bloc_user_image_message
    private val chatUserImage: ImageView = view.chat_user_image
    private val chatUserImageMessageTime: TextView = view.chat_user_image_message_time
    private val blocReceivedImageMessage: ConstraintLayout = view.bloc_received_image_message
    private val chatReceivedImage: ImageView = view.chat_received_image
    private val chatReceivedImageMessageTime: TextView = view.chat_received_image_message_time

    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocUserImageMessage.visibility = View.VISIBLE
            blocReceivedImageMessage.visibility = View.GONE
            chatUserImage.downloadAndSetImage(view.fileUrl)
            chatUserImageMessageTime.text = view.timeStamp.asTime()
        } else {
            blocUserImageMessage.visibility = View.GONE
            blocReceivedImageMessage.visibility = View.VISIBLE
            chatReceivedImage.downloadAndSetImage(view.fileUrl)
            chatReceivedImageMessageTime.text = view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }

}