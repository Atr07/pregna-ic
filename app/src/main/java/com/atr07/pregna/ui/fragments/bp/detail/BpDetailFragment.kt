package com.atr07.pregna.ui.fragments.bp.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atr07.pregna.R

class BpDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BpDetailFragment()
    }

    private lateinit var viewModel: BpDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bp_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BpDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}