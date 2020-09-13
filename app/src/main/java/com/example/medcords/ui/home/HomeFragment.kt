package com.example.medcords.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medcords.R
import com.example.medcords.databinding.FragmentHomeBinding
import com.example.medcords.model.AuthViewModelFactory
import com.example.medcords.network.Api
import com.example.medcords.repository.MainRepository

class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        val api = Api()
        val repository = MainRepository(api)
        val factory = AuthViewModelFactory(repository)

        homeViewModel = ViewModelProvider(this,factory).get(HomeViewModel::class.java)
        binding.viewModel = homeViewModel//attach your viewModel to xml

        homeViewModel.getResponse().observe(viewLifecycleOwner, Observer {res->
           Toast.makeText(context,res.data.rstr,Toast.LENGTH_SHORT).show()
       })
        return binding.root
    }

}