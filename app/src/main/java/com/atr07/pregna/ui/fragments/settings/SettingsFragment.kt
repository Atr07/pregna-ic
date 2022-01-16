package com.atr07.pregna.ui.fragments.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atr07.pregna.R
import com.atr07.pregna.ui.activity.home.MainActivity
import com.atr07.pregna.utils.getLocaleStringResource
import com.atr07.pregna.utils.hideKeyboard

class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        return inflater.inflate(R.layout.settings_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()

        (activity as MainActivity?)?.setToolbarTextAndProfile(
            requireContext().getLocaleStringResource(R.string.settings),
            false
        )
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

}