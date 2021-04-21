package com.example.android_app.ui.fragments.single_chat

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_app.database.CURRENT_UID
import com.example.android_app.ui.fragments.message_recycler_view.view_holders.AppHolderFactory
import com.example.android_app.ui.fragments.message_recycler_view.view_holders.HolderImageMessage
import com.example.android_app.ui.fragments.message_recycler_view.view_holders.HolderTextMessage
import com.example.android_app.ui.fragments.message_recycler_view.views.MessageView
import com.example.android_app.utilits.asTime
import com.example.android_app.utilits.downloadAndSetImage


class SingleChatAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mListMessagesCache = mutableListOf<MessageView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppHolderFactory.getHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return mListMessagesCache[position].getTypeView()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HolderImageMessage -> drawMessageImage(holder, position)
            is HolderTextMessage -> drawMessageText(holder, position)
            else -> {}
        }
    }

    private fun drawMessageText(holder: HolderTextMessage, position: Int) {

        if (mListMessagesCache[position].from == CURRENT_UID) {
            holder.blocUserMessage.visibility = View.VISIBLE
            holder.blocReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = mListMessagesCache[position].text
            holder.chatUserMessageTime.text = mListMessagesCache[position].timeStamp.asTime()
        } else {
            holder.blocUserMessage.visibility = View.GONE
            holder.blocReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = mListMessagesCache[position].text
            holder.chatReceivedMessageTime.text = mListMessagesCache[position].timeStamp.asTime()
        }
    }

    private fun drawMessageImage(holder: HolderImageMessage, position: Int) {

        if (mListMessagesCache[position].from == CURRENT_UID) {
            holder.blocUserImageMessage.visibility = View.VISIBLE
            holder.blocReceivedImageMessage.visibility = View.GONE
            holder.chatUserImage.downloadAndSetImage(mListMessagesCache[position].fileUrl)
            holder.chatUserImageMessageTime.text = mListMessagesCache[position].timeStamp.asTime()
        } else {
            holder.blocUserImageMessage.visibility = View.GONE
            holder.blocReceivedImageMessage.visibility = View.VISIBLE
            holder.chatReceivedImage.downloadAndSetImage(mListMessagesCache[position].fileUrl)
            holder.chatReceivedImageMessageTime.text = mListMessagesCache[position].timeStamp.asTime()
        }
    }

    override fun getItemCount(): Int = mListMessagesCache.size

    fun addItemToBottom(item: MessageView, onSuccess: () -> Unit) {
        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            notifyItemInserted(mListMessagesCache.size)
        }
        onSuccess()
    }

    fun addItemToTop(item: MessageView, onSuccess: () -> Unit) {
        if (!mListMessagesCache.contains(item)) {
            mListMessagesCache.add(item)
            mListMessagesCache.sortBy { it.timeStamp.toString() }
            notifyItemInserted(0)
        }
        onSuccess()
    }
}

