package com.atr07.pregna.ui.fragments.bp.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atr07.pregna.R
import com.atr07.pregna.ui.activity.home.MainActivity

class BpListFragment : Fragment() {

    companion object {
        fun newInstance() = BpListFragment()
    }

    private lateinit var viewModel: BpListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bp_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BpListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity?)?.setToolbarTextAndProfile("Blood Pressure", false)
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}