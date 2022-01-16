package com.atr07.pregna.ui.fragments.music

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

class MusicFragment : Fragment() {

    companion object {
        fun newInstance() = MusicFragment()
    }

    private lateinit var viewModel: MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        return inflater.inflate(R.layout.music_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()

        (activity as MainActivity?)?.setToolbarTextAndProfile(
            requireContext().getLocaleStringResource(R.string.music),
            false
        )
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

}