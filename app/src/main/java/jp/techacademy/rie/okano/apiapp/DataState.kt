package jp.techacademy.rie.okano.apiapp

import java.io.Serializable

data class DataState(
    val id: String,
    val name:String,
    val address:String,
    val imageUrl :String ,
    val url: String
): Serializable