package com.chatuiassesment.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chatuiassesment.data.InComingImageMsg
import com.chatuiassesment.data.InComingMsg
import com.chatuiassesment.databinding.ViewHolderInimageMsgBinding
import com.chatuiassesment.databinding.ViewHolderInmsgBinding

class InImgMsgViewHolder(val binding: ViewHolderInimageMsgBinding): ViewHolder(binding.root) {
    fun bind(msg: InComingImageMsg) {
        with(binding) {
            tvSender.text = msg.senderName
            ivMsg.setImageResource(msg.imageMessage)
            tvTime.text = msg.time
            ivSenderImage.setImageResource(msg.senderImage)
        }
    }
}