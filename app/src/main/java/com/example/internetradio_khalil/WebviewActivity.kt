package com.example.internetradio_khalil

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.webkit.WebView
import android.os.Bundle


import android.webkit.WebViewClient


class WebviewActivity : AppCompatActivity() {
    private lateinit var radioURL: String
    private var view: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the URL:
        // http://playerservices.streamtheworld.com/api/livestream-redirect/kabcam.mp3
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
        //
        //Station Call Letters:  KABC, KARN-AM, KARN-FM, KDXE, KLAL, KURB, WBAP, WFAN, WLS,
        //WWTN, WWYT

        // BBC				https://stream.live.vc.bbcmedia.co.uk/bbc_world_service
        //WNYC				https://fm939.wnyc.org/wnycfm-web
        //KCMP				https://current.stream.publicradio.org/current.mp3

        radioURL = intent.extras?.getString("EXTRA_URL").takeIf { !it.isNullOrBlank() }
            ?: throw IllegalArgumentException("URL ERROR") // catch
        setContentView(R.layout.layout_webview)
        view = findViewById(R.id.web_view)
        if (view != null) {
            view?.webViewClient = WebViewClient()
            setWebSettings(view!!)
            view!!.loadUrl(radioURL)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebSettings(webView: WebView) {
        val webViewSettings = webView.settings
        webViewSettings.javaScriptEnabled = true
        webViewSettings.javaScriptCanOpenWindowsAutomatically = true
    }

    override fun onPause() {
        view?.onPause()
        view?.pauseTimers()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        view?.resumeTimers()
        view?.onResume()
    }

    override fun onDestroy() {
        view?.destroy()
        view = null
        super.onDestroy()
    }
}