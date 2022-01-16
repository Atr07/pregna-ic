package com.atr07.pregna.ui.fragments.dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.atr07.pregna.R
import com.atr07.pregna.databinding.DashboardFragmentBinding
import com.atr07.pregna.ui.activity.home.MainActivity
import com.atr07.pregna.ui.fragments.bp.list.BpListFragment
import com.atr07.pregna.utils.getLocaleStringResource
import com.atr07.pregna.utils.hideKeyboard
import com.atr07.pregna.utils.replaceFragment
import com.atr07.pregna.utils.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: DashboardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()

        setHasOptionsMenu(true)

        (activity as MainActivity?)?.setToolbarTextAndProfile(
            viewModel.appContext.getLocaleStringResource(R.string.dashboard),
            true
        )
        (activity as MainActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)


    }

    private fun goToBpListFrag() {
        (activity as MainActivity?)?.addFragmentBackStack(BpListFragment(), DashboardFragment::class.java.name, null)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_dashboard, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard_notification_menu -> {
                view?.context?.toast("notification")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}