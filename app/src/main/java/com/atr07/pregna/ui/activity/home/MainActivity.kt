package com.atr07.pregna.ui.activity.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.atr07.pregna.R
import com.atr07.pregna.databinding.ActivityMainBinding
import com.atr07.pregna.ui.fragments.dashboard.DashboardFragment
import com.atr07.pregna.ui.fragments.education.EducationFragment
import com.atr07.pregna.ui.fragments.music.MusicFragment
import com.atr07.pregna.ui.fragments.settings.SettingsFragment
import com.atr07.pregna.utils.hideKeyboard
import com.atr07.pregna.utils.toast
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideKeyboard()

        binding.homeToolbar.title = null
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        initBottomNav()

        addFragment(R.id.home_frame_container,DashboardFragment())

        binding.homeToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.fab.setOnClickListener {
            this.toast("add")
        }

        binding.homeProfileImg.setOnClickListener {
            this.toast("profile")
        }
    }

    private fun initBottomNav() {

        binding.homeBottomNavigationView.background = null
        binding.homeBottomNavigationView.menu.getItem(2).isEnabled = false

        binding.homeBottomNavigationView.setOnItemSelectedListener { menuItem ->
            val frag = when (menuItem.itemId) {
                R.id.dashboard_menu -> DashboardFragment()
                R.id.education_menu -> EducationFragment()
                R.id.music_menu -> MusicFragment()
                R.id.settings_menu -> SettingsFragment()
                else -> DashboardFragment()
            }
            addFragment(R.id.home_frame_container,frag)
            Timber.e("click")
            true
        }
    }

    private fun addFragment(frame_layout: Int, newFragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(frame_layout, newFragment)
        transaction.commitAllowingStateLoss()
    }

    fun setToolbarTextAndProfile(title: String, profile: Boolean) {
        binding.homeToolbarTitleTxt.text = title
        binding.homeProfileImg.visibility = if (profile) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    fun addFragmentBackStack(newFragment: Fragment, backStackName: String, args: Bundle? = null) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if (args != null) {
            newFragment.arguments = args
        }
        transaction.replace(R.id.home_frame_container, newFragment, backStackName)
        transaction.addToBackStack(backStackName)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}