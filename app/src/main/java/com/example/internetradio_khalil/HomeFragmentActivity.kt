package com.example.internetradio_khalil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.fragment.app.Fragment
import com.example.internetradio_khalil.R
import com.example.internetradio_khalil.databinding.FragmentHomeBinding

class HomeFragmentActivity : Fragment() {

    private var _bindingControl: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _bindingControl!!

    //The slideshow should display each image for appx 3 seconds. The slideshow should rotate the 3 images continuously for an indefinite period of time. You can display the images, in any order you like –
    // displaying them in alphabetical order is recommended
    // – KABC, KARN-AM, KARN-FM, KLAL, KURB, ...WXYT
    private val slideShowImages = arrayOf(
        R.drawable.kabc,
        R.drawable.karnam,
        R.drawable.karnfm,
        R.drawable.kdxe,
        R.drawable.klal,
        R.drawable.kurb,
        R.drawable.wbap,
        R.drawable.wfan,
        R.drawable.wkim,
        R.drawable.wls,
        R.drawable.wwtn,
        R.drawable.wxyt
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingControl = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        for (i in slideShowImages.indices) {
            val imageView = ImageView(this.requireContext())
            imageView.setImageResource(slideShowImages[i])
            binding.flipper.addView(imageView)
        }
        binding.flipper.isAutoStart = true
        binding.flipper.flipInterval = 3000
        binding.flipper.startFlipping()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingControl = null
    }
}