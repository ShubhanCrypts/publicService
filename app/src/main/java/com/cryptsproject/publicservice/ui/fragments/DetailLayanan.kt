package com.cryptsproject.publicservice.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cryptsproject.publicservice.DaftarActivity
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentDetailLayananBinding
import com.cryptsproject.publicservice.databinding.FragmentLoginBinding

class DetailLayanan : Fragment(R.layout.fragment_detail_layanan) {

    val args: DetailLayananArgs by navArgs()

    private var _binding: FragmentDetailLayananBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailLayananBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var noLayanan = 0

        if (args.noJenisLayanan == 1){
            noLayanan = 1
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Tidak Mampu"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_surat_SKTM)
        }else if (args.noJenisLayanan == 2){
            noLayanan = 2
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Asal"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_surat_SKA)
        }else if (args.noJenisLayanan == 3){
            noLayanan = 3
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Pindah"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_ket_pindah)
        }else if (args.noJenisLayanan == 4){
            noLayanan = 4
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Domisili"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_ket_domisili)
        }else if (args.noJenisLayanan == 5){
            noLayanan = 5
            binding.tvIsiDeskripsiSurat.text = "Surat Rekomendasi Keramaian"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_rek_keramaian)
        }else if (args.noJenisLayanan == 6){
            noLayanan = 6
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Domisili Ormas atau Parpol"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_ket_domisili_parpol)
        }else if (args.noJenisLayanan == 7){
            noLayanan = 7
            binding.tvIsiDeskripsiSurat.text = "Surat Rekomendasi Proposal"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_rek_proposal)
        }else if (args.noJenisLayanan == 8){
            noLayanan = 8
            binding.tvIsiDeskripsiSurat.text = "Surat Rekomendasi Proposal Kelompok"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_rek_proposal_kelompok)
        }else if (args.noJenisLayanan == 9){
            noLayanan = 9
            binding.tvIsiDeskripsiSurat.text = "Surat Izin Usaha Mikro Kecil"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_surat_IUMK)
        }else if (args.noJenisLayanan == 10){
            noLayanan = 10
            binding.tvIsiDeskripsiSurat.text = "Surat Dispensasi Nikah"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_dispensasi_nikah)
        }else if (args.noJenisLayanan == 11){
            noLayanan = 11
            binding.tvIsiDeskripsiSurat.text = "Surat Rekomendasi Pelaksanaan Penelitian"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_rek_pelaksanaan_penelitian)
        }else if (args.noJenisLayanan == 12){
            noLayanan = 12
            binding.tvIsiDeskripsiSurat.text = "Surat Keterangan Selesai Penelitian"
            binding.tvDescPersyaratan.text = getString(R.string.syarat_ket_selesai_penelitian)
        }

        binding.btnDaftarLayanan.setOnClickListener {
            val action = DetailLayananDirections.actionDetailLayananToPendaftaranFragment(noLayanan)
            findNavController().navigate(action)
        }

//        binding.btnDaftarLayanan.setOnClickListener {
//            val intent = Intent(activity, DaftarActivity::class.java)
//            activity?.startActivity(intent)
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}