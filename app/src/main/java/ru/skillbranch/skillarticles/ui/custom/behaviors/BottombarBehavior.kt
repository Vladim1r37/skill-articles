package ru.skillbranch.skillarticles.ui.custom.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.math.MathUtils
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar
import ru.skillbranch.skillarticles.ui.custom.Bottombar
import kotlin.math.max
import kotlin.math.min

class BottombarBehavior @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CoordinatorLayout.Behavior<Bottombar>(context, attrs) {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean =
        axes == ViewCompat.SCROLL_AXIS_VERTICAL

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        val offset = MathUtils.clamp(child.translationY + dy, 0f, child.minHeight.toFloat())
        if (offset != child.translationY) child.translationY = offset
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }
}