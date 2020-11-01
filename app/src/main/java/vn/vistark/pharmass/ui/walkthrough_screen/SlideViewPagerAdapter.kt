package vn.vistark.pharmass.ui.walkthrough_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class SlideViewPagerAdapter : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(container.context)
        val view: View? = layoutInflater?.inflate(
            WalkThroughScreenActivity.layouts.get(position),
            container,
            false
        )
        container.addView(view)
        return view!!
    }

    override fun getCount(): Int {
        return WalkThroughScreenActivity.layouts.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }
}
