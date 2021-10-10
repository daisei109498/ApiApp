package jp.techacademy.rie.okano.apiapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity: AppCompatActivity(), View.OnClickListener{
        var id: String=""
        var name:String=""
        var address:String=""
        var logoImage:String=""
        var couponUrls:String=""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_web_view)

            var state = intent.getSerializableExtra(KEY_URL)
            if(state is DataState) {
                webView.loadUrl(state.url)
                Log.d("ANDROID", state.id)
                id = state.id
                name = state.name
                address=state.address
                logoImage=state.imageUrl
                couponUrls=state.url
                favoriteImageView.apply {
                val isFavorite = FavoriteShop.findBy(state.id) != null
                if (isFavorite) {
                //画像の切り替え
                    setImageResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_star_border) // Picassoというライブラリを使ってImageVIewに画像をはめ込む
                }}
            }
            favoriteImageView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            // お気に入り状態を取得
            var isFavorite = FavoriteShop.findBy(id) != null
            if (isFavorite) {
                onDeleteFavorite(id)
                Log.d("ANDROID", "delete favorite")
            } else {
                onAddFavorite(id, name, address, logoImage, couponUrls)
                Log.d("ANDROID", "add favorite")
            }
        }

        companion object {
            private const val KEY_URL = "key_url"
            fun start(
                activity: Activity,
                id: String,
                name: String,
                address: String,
                imageUrl: String,
                url: String
            ){
                val state = DataState(id, name, address, imageUrl, url)
                activity.startActivity(
                    Intent(activity, WebViewActivity::class.java).putExtra(
                        KEY_URL,
                        state
                    )
                )
            }
        }

        fun onAddFavorite(
            id: String,
            name: String,
            address: String,
            logoImage: String,
            couponUrls: String
        ) { // Favoriteに追加するときのメソッド(Fragment -> Activity へ通知する)
            FavoriteShop.insert(FavoriteShop().apply {
                Log.d("ANDROID", "add favorite id:" + id)
                this.id = id
                this.name = name
                this.address = address
                this.imageUrl = logoImage
                this.url = couponUrls
            })
            favoriteImageView.apply {
                var isFavorite = FavoriteShop.findBy(id) != null
                if (isFavorite) {
                    //画像の切り替え
                    setImageResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_star_border) // Picassoというライブラリを使ってImageVIewに画像をはめ込む
                }
            }
        }

        fun onDeleteFavorite(id: String) { // Favoriteから削除するときのメソッド(Fragment -> Activity へ通知する)
            showConfirmDeleteFavoriteDialog(id)
        }


    private fun showConfirmDeleteFavoriteDialog(id: String) {
            AlertDialog.Builder(this)
                .setTitle(R.string.delete_favorite_dialog_title)
                .setMessage(R.string.delete_favorite_dialog_message)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    deleteFavorite(id)
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->}
                .create()
                .show()
        }
        private fun deleteFavorite(id: String) {
            FavoriteShop.delete(id)
            favoriteImageView.apply {
                //画像の切り替え
                setImageResource(R.drawable.ic_star_border) // Picassoというライブラリを使ってImageVIewに画像をはめ込む
            }
        }

    }