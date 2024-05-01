package com.chatuiassesment.data

import androidx.annotation.DrawableRes
import com.chatuiassesment.R

data class InComingImageMsg(
    val senderName: String,
    @DrawableRes var imageMessage: Int = R.drawable.andimg,
    val time: String,
    @DrawableRes var senderImage: Int = R.drawable.andimg
)
