package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentDashboardBinding
import com.cryptsproject.publicservice.databinding.FragmentDetailLayananBinding
import com.cryptsproject.publicservice.databinding.FragmentLoginBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSKTM.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(1)
            findNavController().navigate(action)
        }

        binding.tvSKA.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(2)
            findNavController().navigate(action)
        }

        binding.tvKetPindah.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(3)
            findNavController().navigate(action)
        }

        binding.tvKetDomisili.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(4)
            findNavController().navigate(action)
        }
        binding.tvRekKeramaian.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(5)
            findNavController().navigate(action)
        }

        binding.tvKetDomisiliOrmas.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(6)
            findNavController().navigate(action)
        }
        binding.tvRekProposalBantuan.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(7)
            findNavController().navigate(action)
        }

        binding.tvRekProposalKelompok.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(8)
            findNavController().navigate(action)
        }
        binding.tvIUMK.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(9)
            findNavController().navigate(action)
        }

        binding.tvDispNikah.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(10)
            findNavController().navigate(action)
        }
        binding.tvRekPenelitian.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(11)
            findNavController().navigate(action)
        }

        binding.tvKetSelesaiPenelitian.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailLayanan2(12)
            findNavController().navigate(action)
        }

        binding.etProfile.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}