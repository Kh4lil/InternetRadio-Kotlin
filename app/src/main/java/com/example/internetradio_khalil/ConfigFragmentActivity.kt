package com.example.internetradio_khalil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.internetradio_khalil.databinding.FragmentConfigBinding


class ConfigFragmentActivity : Fragment() {
    private var _bindingControl: FragmentConfigBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _bindingControl!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingControl = FragmentConfigBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener {
            val name:String = binding.nameEt.text.trim().toString()
            val url:String = binding.urlEt.text.trim().toString()
            ChannelFragmentActivity.channels[name] = url
            AlertDialog.Builder(requireContext())
                .setTitle("Success")
                .setMessage("Channel has been added")
                .setNeutralButton("Ok",null)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingControl = null
    }
}