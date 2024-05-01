package com.chatuiassesment.data

import androidx.annotation.DrawableRes
import com.chatuiassesment.R

data class InComingMsg(
    val senderName: String,
    val message: String,
    val time: String,
    @DrawableRes var senderImage: Int = R.drawable.andimg
)
