package com.chatuiassesment.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chatuiassesment.data.InComingMsg
import com.chatuiassesment.databinding.ViewHolderInmsgBinding


class InMsgViewHolder(val binding: ViewHolderInmsgBinding): ViewHolder(binding.root) {
    fun bind(msg: InComingMsg) {
        with(binding) {
            tvSender.text = msg.senderName
            tvMsg.text = msg.message
            tvTime.text = msg.time
            ivSenderImage.setImageResource(msg.senderImage)
        }
    }
}