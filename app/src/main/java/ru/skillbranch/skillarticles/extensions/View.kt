package ru.skillbranch.skillarticles.extensions

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import androidx.navigation.NavDestination
import com.google.android.material.bottomnavigation.BottomNavigationView

fun View.setMarginOptionally(left: Int = marginLeft, top: Int = marginTop,
                             right: Int = marginRight,  bottom: Int = marginBottom) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val lParams = layoutParams as ViewGroup.MarginLayoutParams
        lParams.setMargins(left, top, right, bottom)
        requestLayout()
    }
}

fun View.setPaddingOptionally(left: Int = paddingLeft, top: Int = paddingTop,
                             right: Int = paddingRight,  bottom: Int = paddingBottom) {
    this.setPadding(left, top, right, bottom)
}

fun View.selectDestination(destination: NavDestination) {
    selectItem(destination.id)
}

fun View.selectItem(itemId: Int?) {
    itemId ?: return
    val menu = (this as BottomNavigationView).menu
    for (item in menu.iterator()) {
        if (item.itemId == itemId) {
            item.isChecked = true
            break
        }
    }
}

