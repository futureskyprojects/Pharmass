package vn.vistark.pharmass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vn.vistark.pharmass.ui.splash.SplashActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Chuyển màn hình sang Splash screen
        goToSplash()
    }

    private fun goToSplash() {
        // Tạo thể hiện chuyển đổi ngữ cảnh sang màn hình mời
        val intent = Intent(this, SplashActivity::class.java)
        // Bắt đầu activity mới
        startActivity(intent)
        // kết thúc activity hiện tại
        finish()
    }
}