package com.app.abc.domain.model

import androidx.annotation.ColorRes
import com.app.abc.R

enum class Category( @ColorRes val imageRes:Int) {
    Business(R.drawable.c_business),
    Sports(R.drawable.c_sports),
    Health(R.drawable.c_health),
    Technology(R.drawable.c_technology),

}
