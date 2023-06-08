package co.tiagoaguiar.course.instagram

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class IconItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val textStringId: Int,
    val color: Int

)
