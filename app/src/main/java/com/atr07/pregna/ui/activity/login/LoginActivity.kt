package com.atr07.pregna.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atr07.pregna.R
import com.atr07.pregna.databinding.ActivityLoginBinding
import com.atr07.pregna.ui.activity.home.MainActivity
import com.atr07.pregna.utils.*

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideKeyboard()

        binding.loginBtn.setOnClickListener {
            hideKeyboard()
            clearError()
            validateLoginInput()
        }
    }

    private fun clearError() {
        binding.loginEmailEditTxt.error = null
        binding.loginPasswordEditTxt.error = null
    }

    private fun validateLoginInput() {
        val mEmail = binding.loginEmailEditTxt.text
        val mPassword = binding.loginPasswordEditTxt.text

        if (mEmail.isNullOrEmptyOrBlank()) {
            binding.loginEmailEditTxt.error = this.getLocaleStringResource(R.string.enter_email)
            this.toast(this.getLocaleStringResource(R.string.enter_email))
            return
        }

        if (mPassword.isNullOrEmptyOrBlank()) {
            binding.loginPasswordEditTxt.error = this.getLocaleStringResource(R.string.enter_password)
            this.toast(this.getLocaleStringResource(R.string.enter_password))
            return
        }

        if (!mEmail.isValidEmail()) {
            binding.loginEmailEditTxt.error = this.getLocaleStringResource(R.string.enter_valid_email)
            this.toast(this.getLocaleStringResource(R.string.enter_valid_email))
            return
        }

        if (!mPassword.isStrongPassword()) {
            binding.loginPasswordEditTxt.error = this.getLocaleStringResource(R.string.enter_strong_password)
            this.toast(this.getLocaleStringResource(R.string.enter_strong_password))
            return
        }

        this.toast(this.getLocaleStringResource(R.string.login_success))

        gotoDashboard()

    }

    private fun gotoDashboard() {
        val intent = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intent)
    }
}