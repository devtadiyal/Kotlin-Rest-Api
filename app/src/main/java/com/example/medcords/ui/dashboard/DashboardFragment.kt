package com.example.medcords.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.medcords.R
import com.example.medcords.databinding.FragmentDashboardBinding
import com.example.medcords.ui.home.HomeViewModel
import com.example.medcords.utils.BaseFragment

class DashboardFragment : BaseFragment<FragmentDashboardBinding,DashboardViewModel>() {

    override fun getFragmentView() = R.layout.fragment_dashboard
    override fun getViewModel() = DashboardViewModel::class.java

    private lateinit var dashboardViewModel: DashboardViewModel

    /*override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }*/
}