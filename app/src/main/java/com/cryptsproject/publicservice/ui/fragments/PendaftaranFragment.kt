package com.cryptsproject.publicservice.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.app.uploadfiles.FilesUploader
import com.cryptsproject.publicservice.MainActivity
import com.cryptsproject.publicservice.R
import com.cryptsproject.publicservice.databinding.FragmentDetailLayananBinding
import com.cryptsproject.publicservice.databinding.FragmentLoginBinding
import com.cryptsproject.publicservice.databinding.FragmentPendaftaranBinding
import com.google.protobuf.Value
import im.delight.android.webview.AdvancedWebView
import java.util.*

lateinit var webViewGlobal: AdvancedWebView

class PendaftaranFragment : Fragment(R.layout.fragment_pendaftaran), AdvancedWebView.Listener {

    private val filesUploader: FilesUploader by lazy { FilesUploader(this@PendaftaranFragment.requireActivity()) }

    private var _binding: FragmentPendaftaranBinding? = null

    private val binding get() = _binding!!

    val args: PendaftaranFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPendaftaranBinding.inflate(inflater, container, false)
//        webViewGlobal = binding.pendaftaranWebview
        val view = binding.root

        webViewGlobal = binding.pendaftaranWebview
        webViewGlobal.setListener(activity, this)
        webViewGlobal.setMixedContentAllowed(false)
//        binding.pendaftaranWebview.loadUrl("https://smallpdf.com/id/pdf-reader")
        Log.d("debug", AdvancedWebView.isFileUploadAvailable().toString())
//        webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf7_NDuFaM9J7Fojui7o8zckMRq8cb7rKn-Z_UADD93xPpljg/viewform?usp=sf_link")
        if (args.noJenisLayanan == 1) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSe5KSSNY4gNMLINn2wjUoVVzBRyu8agyJalCA0WZNzWtKuw7g/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 2) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfHZPWKqos2EbDpkvK6q1YMXgG2mgJllZSr2r486UFiVfDgLg/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 3) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeQTfQdy08W3KWUTbiW8DfSLdF3iRDK1fHLsQafWOv-e2gPBg/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 4) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScFRsGiOsJ4SkmDnOb7i-cRNQ6N5F_0OyjNB7r_rdd_VcW4Sw/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 5) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScURyhtEq7QUT52OvQY1r6ZmAx6KYbz6n-1A6t_TCNDrLbwQg/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 6) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSegHMYPjF9h3Wc68mPj7dedz4nocM7f9Pg7_X4u0GK83dnf4Q/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 7) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScWYJjQnNO1Z-AXITirqQP_R_gJt1Qcz7CZw1qaU_mNnIkjFA/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 8) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfUIIEr_MVqo88MN9mNr-ZICLUYhIjTobpieevTQJmFn4sxfw/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 9) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfMBMT5uHQpMDkW9vviWK4Dw6A0ariJkjLm2LmMZFGiDUPhcw/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 10) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSe342rjUMbkK9ZAd3xAC7cVNOCVYwGfVDltFjZ1u0F9JTn4lQ/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 11) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfMarZhRweX0MXsm52NMLX45NIEREaOc7-shh-Vpyj6FewbzQ/viewform?usp=sf_link")
        } else if (args.noJenisLayanan == 12) {
            webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeg0Bg5hI5I39VXNZ0AQAPr1SC5lkdLQjcSd9YicIgoF_SHnw/viewform?usp=sf_link")
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        webViewGlobal = binding.pendaftaranWebview
//        webViewGlobal.setListener(this@PendaftaranFragment.requireActivity(), this)
//        webViewGlobal.setMixedContentAllowed(false)
////        binding.pendaftaranWebview.loadUrl("https://smallpdf.com/id/pdf-reader")
//        Log.d("debug", AdvancedWebView.isFileUploadAvailable().toString())
//
//        webViewGlobal.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf7_NDuFaM9J7Fojui7o8zckMRq8cb7rKn-Z_UADD93xPpljg/viewform?usp=sf_link")

//        binding.pendaftaranWebview.apply {
//            webViewClient = WebViewClient()
//            webChromeClient = object : WebChromeClient(){
//                override fun onShowFileChooser(
//                    webView: WebView?,
//                    filePathCallback: ValueCallback<Array<Uri>>?,
//                    fileChooserParams: FileChooserParams?
//                ): Boolean {
//                    return filesUploader.onShowFileChooser(binding.pendaftaranWebview, filePathCallback, fileChooserParams)
//                }
//            }
//            loadUrl("https://smallpdf.com/id/pdf-reader")
//            settings.javaScriptEnabled = true
//            settings.domStorageEnabled = true
//            settings.allowFileAccess = true
//            settings.allowContentAccess = true
////            loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf7_NDuFaM9J7Fojui7o8zckMRq8cb7rKn-Z_UADD93xPpljg/viewform?usp=sf_link")
//
//        }
//            webChromeClient = object : WebChromeClient() {
//            override fun onShowFileChooser(
//                webView: WebView,
//                filePathCallback: ValueCallback<Array<Uri>>,
//                fileChooserParams: FileChooserParams
//            ): Boolean {
//                if (mUMA != null) {
//                    mUMA!!.onReceiveValue(null)
//                }
//                mUMA = filePathCallback
//                var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                if (takePictureIntent!!.resolveActivity(requireActivity().getPackageManager()) != null) {
//                    var photoFile: File? = null
//                    try {
//                        photoFile = createImageFile()
//                        takePictureIntent.putExtra("PhotoPath", mCM)
//                    } catch (ex: IOException) {
//                        Log.e("Webview", "Image file creation failed", ex)
//                    }
//                    if (photoFile != null) {
//                        mCM = "file:" + photoFile.getAbsolutePath()
//                        takePictureIntent.putExtra(
//                            MediaStore.EXTRA_OUTPUT,
//                            Uri.fromFile(photoFile)
//                        )
//                    } else {
//                        takePictureIntent = null
//                    }
//                }
//                val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
//                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
//                contentSelectionIntent.type = "*/*"
//                val intentArray: Array<Intent>
//                intentArray = takePictureIntent?.let { arrayOf(it) } ?: arrayOf<Intent>()
//                val chooserIntent = Intent(Intent.ACTION_CHOOSER)
//                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
//                chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
//                startActivityForResult(chooserIntent, FCR)
//                return true
//            }
//        }
//
//            // Create an image file
//            @Throws(IOException::class)
//            private fun createImageFile(): File? {
//                @SuppressLint("SimpleDateFormat") val timeStamp: String =
//                    SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//                val imageFileName = "img_" + timeStamp + "_"
//                val storageDir: File =
//                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//                return File.createTempFile(imageFileName, ".jpg", storageDir)
//            }
//            fun openFileChooser(uploadMsg: ValueCallback<Uri?>?) {
//                this.openFileChooser(uploadMsg, "*/*")
//            }
//
//            fun openFileChooser(
//                uploadMsg: ValueCallback<Uri?>?,
//                acceptType: String?
//            ) {
//                this.openFileChooser(uploadMsg, acceptType, null)
//            }
//
//            fun openFileChooser(
//                uploadMsg: ValueCallback<Uri?>?,
//                acceptType: String?,
//                capture: String?
//            ) {
//                val i = Intent(Intent.ACTION_GET_CONTENT)
//                i.addCategory(Intent.CATEGORY_OPENABLE)
//                i.type = "*/*"
//                this@MainActivity.startActivityForResult(
//                    Intent.createChooser(i, "File Browser"),
//                    FILECHOOSER_RESULTCODE
//                )
//            }
//
//            override fun onActivityResult(
//                requestCode: Int,
//                resultCode: Int,
//                intent: Intent?
//            ) {
//                super.onActivityResult(requestCode, resultCode, intent)
//                if (Build.VERSION.SDK_INT >= 21) {
//                    var results: Array<Uri>? = null
//                    //Check if response is positive
//                    if (resultCode == Activity.RESULT_OK) {
//                        if (requestCode == FCR) {
//                            if (null == mUMA) {
//                                return
//                            }
//                            if (intent == null) { //Capture Photo if no image available
//                                if (mCM != null) {
//                                    results = arrayOf(Uri.parse(mCM))
//                                }
//                            } else {
//                                val dataString = intent.dataString
//                                if (dataString != null) {
//                                    results = arrayOf(Uri.parse(dataString))
//                                }
//                            }
//                        }
//                    }
//                    mUMA!!.onReceiveValue(results)
//                    mUMA = null
//                } else {
//                    if (requestCode == FCR) {
//                        if (null == mUM) return
//                        val result =
//                            if (intent == null || resultCode != Activity.RESULT_OK) null else intent.data
//                        mUM!!.onReceiveValue(result)
//                        mUM = null
//                    }
//                }
//            }
//
///*needed fileds
// private var mCM: String? = null
// private var mUM: ValueCallback<Uri>? = null
// private var mUMA: ValueCallback<Array<Uri>>? = null
// private const val FCR = 1*/
//        }
////        binding.pendaftaranWebview.settings.javaScriptEnabled = true
////        binding.pendaftaranWebview.settings.domStorageEnabled = true
////        binding.pendaftaranWebview.settings.allowFileAccess = true
////        binding.pendaftaranWebview.settings.allowContentAccess = true
//
//        binding.pendaftaranWebview.settings.javaScriptEnabled = true
//        binding.pendaftaranWebview.settings.loadWithOverviewMode = true
//        binding.pendaftaranWebview.settings.useWideViewPort = true
//        binding.pendaftaranWebview.settings.domStorageEnabled = true
//        binding.pendaftaranWebview.settings.allowFileAccess=true
//        binding.pendaftaranWebview.settings.allowContentAccess=true
//        binding.pendaftaranWebview.settings.allowUniversalAccessFromFileURLs=true
//        binding.pendaftaranWebview.settings.allowFileAccessFromFileURLs=true
//        binding.pendaftaranWebview.settings.javaScriptCanOpenWindowsAutomatically=true
//        binding.pendaftaranWebview.settings.webChrome

//        }


    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        webViewGlobal.onActivityResult(requestCode, resultCode, data)
////        if (_binding != null){
////            _bind
////        }
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        filesUploader.onActivityResult(requestCode, resultCode, data)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
    }

    //
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