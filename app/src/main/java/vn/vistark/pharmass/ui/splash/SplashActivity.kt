package vn.vistark.pharmass.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vn.vistark.pharmass.R
import vn.vistark.pharmass.ui.walkthrough_screen.WalkThroughScreenActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Chuyển màn hình sang WalkThrough
        gotoWalkThroughScreen()
    }

    private fun gotoWalkThroughScreen() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //Tạo thể hiện chuyển đổi ngữ cảnh sang màn hình WalkThrogh
                val intent = Intent(this@SplashActivity, WalkThroughScreenActivity::class.java)
                //Bắt đầu activity mới
                startActivity(intent)
                //Kết thúc activity hiện tại
                finish()
            }
        }, 3000)
    }
}