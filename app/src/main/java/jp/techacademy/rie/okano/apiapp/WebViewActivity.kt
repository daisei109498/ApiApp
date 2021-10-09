package jp.techacademy.rie.okano.apiapp

import android.app.Activity
import android.content.Intent
import android.content.LocusId
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*

    class WebViewActivity: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_web_view)
            val state = intent.getSerializableExtra(KEY_URL)
            if(state is DataState){
                webView.loadUrl(state.url)
            }
        }

        companion object {
            private const val KEY_URL = "key_url"
            fun start(activity: Activity, url:String,id:String){
                val state = DataState(url, id)
                activity.startActivity(
                    Intent(activity, WebViewActivity::class.java).putExtra(
                        KEY_URL,
                        state
                    )
                )
            }
        }
    }