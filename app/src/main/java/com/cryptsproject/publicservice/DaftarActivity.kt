package com.cryptsproject.publicservice

import android.content.ClipData
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.cryptsproject.publicservice.databinding.ActivityDaftarBinding
import im.delight.android.webview.AdvancedWebView

var uploadMessage: ValueCallback<Array<Uri>>? = null
private const val file_type = "*/*" // file types to be allowed for upload

private const val multiple_files = true


class DaftarActivity : AppCompatActivity(), AdvancedWebView.Listener {
    private lateinit var mWebView: AdvancedWebView

    private lateinit var binding: ActivityDaftarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDaftarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mWebView = binding.webviewDaftar
        mWebView.setListener(this, this)
        mWebView.setMixedContentAllowed(false)
//        mWebView.loadUrl("https://smallpdf.com/id/pdf-reader")
        mWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf7_NDuFaM9J7Fojui7o8zckMRq8cb7rKn-Z_UADD93xPpljg/viewform?usp=sf_link")

//        binding.webviewDaftar.setListener

//        binding.webviewDaftar.loadUrl("https://smallpdf.com/id/pdf-reader")
//        binding.webviewDaftar.webViewClient = WebViewClient()
//
//        val webSettings = binding.webviewDaftar.settings
//        webSettings.javaScriptEnabled = true
//        webSettings.allowFileAccess = true
//        webSettings.domStorageEnabled = true
//        webSettings.allowContentAccess = true
//        webSettings.allowFileAccess = true
//        webSettings.javaScriptCanOpenWindowsAutomatically = true
//
//        binding.webviewDaftar.webViewClient = object : WebViewClient() {
//
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//
//                val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(i)
//
//                return true
//
//            }
//
//        }
//
//        binding.webviewDaftar.setWebChromeClient(object : WebChromeClient() {
//
//
//            override fun onShowFileChooser(
//                view: WebView,
//                filePathCallback: ValueCallback<Array<Uri>>,
//                fileChooserParams: FileChooserParams
//            ): Boolean {
//
//                uploadMessage = filePathCallback
//
//
//                val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
//                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
//                contentSelectionIntent.type = file_type
//                if (multiple_files) {
//                    contentSelectionIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//                }
//
//                val chooserIntent = Intent(Intent.ACTION_CHOOSER)
//                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
//                chooserIntent.putExtra(Intent.EXTRA_TITLE, "File chooser")
//                startActivityForResult(chooserIntent, 1)
//                return true
//
//
//            }
//
//        })
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intent)
//        if (Build.VERSION.SDK_INT >= 21) {
//            var results: Array<Uri?>? = null
//
//            if (resultCode == RESULT_CANCELED) {
//                uploadMessage?.onReceiveValue(null)
//                return
//            }
//
//            Log.d("danieldebug", "override called")
//
//            if (resultCode == RESULT_OK) {
//
//                var clipData: ClipData?
//                var stringData: String?
//                try {
//                    clipData = intent!!.clipData
//                    stringData = intent.dataString
//                    Log.d("debug", "clipdata: $clipData")
//                    Log.d("debug", "stringdata: $stringData")
//                } catch (e: Exception) {
//                    clipData = null
//                    stringData = null
//                }
//
//                if (clipData != null) { // checking if multiple files selected or not
//                    val numSelectedFiles = clipData.itemCount
//                    results = arrayOfNulls(numSelectedFiles)
//                    for (i in 0 until clipData.itemCount) {
//                        results[i] = clipData.getItemAt(i).uri
//                    }
//                }
//            }
//            if (results != null){
//                Log.d("debug", "results are not null")
//                Log.d("debug", "$results")
//                uploadMessage?.onReceiveValue(results as Array<Uri>)
//            }
//
//            uploadMessage = null
//
//        }
//    }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mWebView.onActivityResult(requestCode, resultCode, data)
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
    }

    override fun onPageFinished(url: String?) {
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
    }

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?
    ) {
    }

    override fun onExternalPageRequest(url: String?) {
    }
}