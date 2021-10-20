package com.example.internetradio_khalil

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.example.internetradio_khalil.WebviewActivity
import com.example.internetradio_khalil.databinding.FragmentChannelBinding


class ChannelFragmentActivity : Fragment() {
    private var _bindingControl: FragmentChannelBinding? = null
    private var buttonContainer: LinearLayout? = null

    companion object {

        //Station Call Letters:  KABC, KARN-AM, KARN-FM, KDXE, KLAL, KURB, WBAP, WFAN, WLS,
        //WWTN, WWYT


        //The corresponding URLs (same as APP2) are given below:
        //
        //http://playerservices.streamtheworld.com/api/livestream-redirect/kabcam.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/karnam.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/karnfm.mp3"
        //http://playerservices.streamtheworld.com/api/livestream-redirect/kdxefm.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/klalfm.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/kurbfm.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/wbapam.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/wfanam.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/wlsam.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/wwtnfm.mp3
        //http://playerservices.streamtheworld.com/api/livestream-redirect/wwytfm.mp3



        // First we get the buttons for each channel in map:
        val channels = mutableMapOf(
            "KABC" to "http://playerservices.streamtheworld.com/api/livestream-redirect/kabcam.mp3",
            "KARNAM" to "http://playerservices.streamtheworld.com/api/livestream-redirect/karnam.mp3",
            "KARNFM" to "http://playerservices.streamtheworld.com/api/livestream-redirect/karnfm.mp3",
            "KDXE" to "http://playerservices.streamtheworld.com/api/livestream-redirect/kdxefm.mp3",
            "KLAL" to "http://playerservices.streamtheworld.com/api/livestream-redirect/klalfm.mp3",
            "KURB" to "http://playerservices.streamtheworld.com/api/livestream-redirect/kurbfm.mp3",
            "WBAP" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wbapam.mp3",
            "WFAN" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wam.mp3",
            "WKIM" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wkimam.mp3",
            "WLS" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wlsam.mp3",
            "WWTN" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wwtnfm.mp3",
            "WXYT" to "http://playerservices.streamtheworld.com/api/livestream-redirect/wwytfm.mp3"
        )
    }
    private val binding get() = _bindingControl!!

    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {


        _bindingControl = FragmentChannelBinding.inflate(inflater, container, false)
        val root: View = binding.root

        buttonContainer = binding.buttonContainer

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //iterate through the channels


        channels.forEach {
            val channel = MaterialButton(requireContext())

            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            layoutParams.topMargin = dpToPx(12f)
            channel.text = it.key

            channel.setOnClickListener { view ->
                val intent = Intent(requireContext(), WebviewActivity::class.java).putExtra(
                    "EXTRA_URL", it.value
                )
                if(it.value.isNotEmpty())
                    startActivity(intent)
            }
            buttonContainer?.addView(channel)
        }

    }

    private fun dpToPx(dp: Float): Int {
        val r: Resources = requireContext().resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            r.displayMetrics
        ).toInt()
        return px
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingControl = null
    }
}