package com.atr07.pregna.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.text.Editable
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.atr07.pregna.R
import java.util.*

/**
 * Created by Adithya T Raj.
 **/

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun Context.getLocaleStringResource(
    resourceId: Int,
): String {
    val requestedLocale = Locale.getDefault()
    val result: String
    val config =
        Configuration(resources.configuration)
    config.setLocale(requestedLocale)
    result = createConfigurationContext(config).getText(resourceId).toString()

    return result
}

fun Editable?.isNullOrEmptyOrBlank() = this.isNullOrEmpty() or this.isNullOrBlank()

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG ).show()
}

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun CharSequence?.isStrongPassword() = !isNullOrEmpty() && this.length >= PASSWORD_MIN_LENGTH

fun FragmentActivity.replaceFragment(fragment: Fragment, addToStack: Boolean, frameId: Int = R.id.home_frame_container) {
    val doesFragmentAlreadyExists = supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) != null
    if (!doesFragmentAlreadyExists) {
        if (addToStack) {
            supportFragmentManager.beginTransaction().replace(frameId, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
        }
        else {
            supportFragmentManager.beginTransaction().replace(frameId, fragment, fragment.javaClass.simpleName)
        }
    }}
