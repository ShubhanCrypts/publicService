package com.cryptsproject.publicservice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentPengaduanBinding
import com.cryptsproject.publicservice.databinding.FragmentProfileBinding
import im.delight.android.webview.AdvancedWebView

lateinit var webViewPengaduan: AdvancedWebView

class PengaduanFragment : Fragment(R.layout.fragment_pengaduan) {

    private var _binding: FragmentPengaduanBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPengaduanBinding.inflate(inflater, container, false)
        val view = binding.root

        webViewPengaduan = binding.wvPengaduan
//        webViewPengaduan.setListener(activity, this)
        webViewPengaduan.setMixedContentAllowed(false)
        webViewPengaduan.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfg-yaML_8oNLg008RiCXbvEMIPRGR5n-k3IoUPWGz52UVDRQ/viewform?usp=sf_link")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}