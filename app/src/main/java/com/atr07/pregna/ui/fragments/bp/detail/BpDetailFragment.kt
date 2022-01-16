package com.atr07.pregna.ui.fragments.bp.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atr07.pregna.R
import com.atr07.pregna.databinding.BpDetailFragmentBinding
import com.atr07.pregna.ui.activity.home.MainActivity
import com.atr07.pregna.utils.getLocaleStringResource
import com.atr07.pregna.utils.hideKeyboard
import com.atr07.pregna.utils.toast

class BpDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BpDetailFragment()
    }

    private lateinit var viewModel: BpDetailViewModel
    private lateinit var binding: BpDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(BpDetailViewModel::class.java)
        binding = BpDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()

        setHasOptionsMenu(true)

        (activity as MainActivity?)?.setToolbarTextAndProfile(
            requireContext().getLocaleStringResource(R.string.details),
            false
        )
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_details, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.details_edit_menu -> {
                view?.context?.toast("edit")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}