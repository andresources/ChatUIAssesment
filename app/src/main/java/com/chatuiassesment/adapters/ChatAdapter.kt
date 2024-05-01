package com.apolis45.chatuidemo.adatpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chatuiassesment.data.InComingImageMsg
import com.chatuiassesment.data.InComingMsg
import com.chatuiassesment.data.OutGoingMsg
import com.chatuiassesment.databinding.ViewHolderInimageMsgBinding
import com.chatuiassesment.databinding.ViewHolderInmsgBinding
import com.chatuiassesment.databinding.ViewHolderOutmsgBinding
import com.chatuiassesment.viewholders.InImgMsgViewHolder
import com.chatuiassesment.viewholders.InMsgViewHolder
import com.chatuiassesment.viewholders.OutMsgViewHolder


class ChatAdapter(val messages: MutableList<Any>): Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == VIEW_TYPE_IN_MSG) {
            val binding = ViewHolderInmsgBinding.inflate(inflater, parent, false)
            return InMsgViewHolder(binding)
        } else if(viewType == VIEW_TYPE_OUT_MSG) {
            val binding = ViewHolderOutmsgBinding.inflate(inflater, parent, false)
            return OutMsgViewHolder(binding)
        }else if(viewType == VIEW_TYPE_IN_IMG_MSG) {
            val binding = ViewHolderInimageMsgBinding.inflate(inflater, parent, false)
            return InImgMsgViewHolder(binding)
        }
        throw RuntimeException("Unknown View Type")
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(holder is InMsgViewHolder) {
            holder.bind(messages[position] as InComingMsg)
        } else if(holder is OutMsgViewHolder) {
            holder.bind(messages[position] as OutGoingMsg)
        }else if(holder is InImgMsgViewHolder) {
            holder.bind(messages[position] as InComingImageMsg)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(messages[position] is InComingMsg) {
            return VIEW_TYPE_IN_MSG
        } else if(messages[position] is OutGoingMsg) {
            return VIEW_TYPE_OUT_MSG
        }else if(messages[position] is InComingImageMsg) {
            return VIEW_TYPE_IN_IMG_MSG
        }
        return super.getItemViewType(position)
    }

    companion object {
        const val VIEW_TYPE_IN_MSG = 20
        const val VIEW_TYPE_OUT_MSG = 30
        const val VIEW_TYPE_IN_IMG_MSG = 40
    }
}