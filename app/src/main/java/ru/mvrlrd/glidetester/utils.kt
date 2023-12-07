package ru.mvrlrd.glidetester

import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide

val Any.TAG : String
    get() = this.javaClass.simpleName

fun log(tag: String, text: String){
    Log.d(tag, text)
}

fun ImageView.loadWithGlide(fragment: Fragment) {
    Glide.with(fragment)
        .load(IMAGE_URL)
        .into(this)
}

fun ImageView.loadWithCoil(){
    this.load(IMAGE_URL)
}

fun MainActivity.loadImage(tool: ImageTools){
    when(tool){
         ImageTools.GLIDE ->{
            Glide.with(this)
                .load(IMAGE_URL)
                .into(this.binding.iv)
        }
        ImageTools.COIL ->{
            this.binding.iv.loadWithCoil()
        }
    }
}

enum class ImageTools{
    GLIDE,
    COIL
}

const val IMAGE_URL = "https://mirpozitiva.ru/wp-content/uploads/2019/11/1476889932_zakat-derevo.jpg"
