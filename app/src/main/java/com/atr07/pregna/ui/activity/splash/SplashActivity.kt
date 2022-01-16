package com.atr07.pregna.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.atr07.pregna.databinding.ActivitySplashBinding
import com.atr07.pregna.ui.activity.login.LoginActivity
import com.atr07.pregna.utils.APP_SPLASH_TIME_MILLI
import com.atr07.pregna.utils.hideKeyboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideKeyboard()

        lifecycleScope.launch(Dispatchers.Main) {
            delay(APP_SPLASH_TIME_MILLI)
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        finish()
        startActivity(intent)
    }

}