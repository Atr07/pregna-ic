package com.atr07.pregna.ui.fragments.bp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atr07.pregna.R
import com.atr07.pregna.databinding.BpListFragmentBinding
import com.atr07.pregna.ui.activity.home.MainActivity
import com.atr07.pregna.ui.fragments.bp.detail.BpDetailFragment
import com.atr07.pregna.utils.getLocaleStringResource
import com.atr07.pregna.utils.hideKeyboard

class BpListFragment : Fragment() {

    companion object {
        fun newInstance() = BpListFragment()
    }

    private lateinit var viewModel: BpListViewModel
    private lateinit var binding: BpListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(BpListViewModel::class.java)
        binding = BpListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()

        (activity as MainActivity?)?.setToolbarTextAndProfile(requireContext().getLocaleStringResource(R.string.blood_pressure), false)
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.date1Layout.setOnClickListener {
            goToBpDetailFrag()
        }

        binding.date2Layout.setOnClickListener {
            goToBpDetailFrag()
        }
    }

    private fun goToBpDetailFrag() {
        (activity as MainActivity?)?.addFragmentBackStack(BpDetailFragment(), BpListFragment::class.java.name, null)
    }

}