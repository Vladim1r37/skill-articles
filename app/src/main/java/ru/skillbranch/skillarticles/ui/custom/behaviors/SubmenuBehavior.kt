package ru.skillbranch.skillarticles.ui.custom.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import ru.skillbranch.skillarticles.ui.custom.ArticleSubmenu

class SubmenuBehavior @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CoordinatorLayout.Behavior<ArticleSubmenu>(context, attrs) {
    var isHidden = false

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: ArticleSubmenu,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean =
        axes == ViewCompat.SCROLL_AXIS_VERTICAL

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: ArticleSubmenu,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        if (dy > 0 && child.isOpen && !isHidden) {
            child.hide()
            isHidden = true
        }
        if (dy < 0 && isHidden) {
            child.show()
            isHidden = false
        }
    }
}