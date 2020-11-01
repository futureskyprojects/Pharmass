package vn.vistark.pharmass.ui.walkthrough_screen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_walk_through_screen.*
import vn.vistark.pharmass.R

class WalkThroughScreenActivity : AppCompatActivity() {
    private var slideViewPagerAdapter: SlideViewPagerAdapter? = null

    private lateinit var dots: Array<TextView?>

    companion object {
        lateinit var layouts: IntArray
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        setContentView(R.layout.activity_walk_through_screen)

        layouts = intArrayOf(
            R.layout.welcome_slide1,
            R.layout.welcome_slide2
        )

        // adding bottom dots
        addBottomDots(0)

        // making notification bar transparent
        changeStatusBarColor()
        slideViewPagerAdapter = SlideViewPagerAdapter()
        asVpIntro.adapter = slideViewPagerAdapter
        asVpIntro.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        asLnlDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i]!!.text = Html.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
            } else {
                dots[i]!!.text = Html.fromHtml("&#8226;")
            }
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(Color.parseColor("#E4E4E4"))
            asLnlDots!!.addView(dots[i])
        }
        if (dots.isNotEmpty()) dots[currentPage]!!.setTextColor(Color.parseColor("#71C549"))
    }

    private fun getItem(i: Int): Int {
        return asVpIntro.currentItem + i
    }

    //  viewpager change listener
    var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object :
        ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                asBtnSkip.text = "Hoàn tất"
            } else {
                // still pages are left
                asBtnSkip.text = "Bỏ qua"
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }
}