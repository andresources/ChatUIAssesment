package com.chatuiassesment.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chatuiassesment.PopUpClass
import com.chatuiassesment.data.OutGoingMsg
import com.chatuiassesment.databinding.ViewHolderOutmsgBinding

class OutMsgViewHolder(val binding: ViewHolderOutmsgBinding): ViewHolder(binding.root) {
   /* PopUpClass popUpClass = new PopUpClass();
    popUpClass.showPopupWindow(v);*/
    fun bind(msg: OutGoingMsg) {
        with(binding) {
            tvMsg.text = msg.message
            tvTime.text = msg.time
               ivInfo.setOnClickListener {
                   PopUpClass().showPopupWindow(ivInfo,"Message Time : "+msg.time)
               }
        }
    }
}