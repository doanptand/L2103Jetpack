package com.ddona.jetpack.extension

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import com.bumptech.glide.Glide
import com.ddona.jetpack.R
import com.ddona.jetpack.model.Passenger

@BindingAdapter("set_url")
fun bindImageView(img: ImageView, link: String) {
    Glide.with(img)
        .load(link)
        .placeholder(R.mipmap.ic_launcher)
        .into(img)
}

@RequiresApi(Build.VERSION_CODES.N)
@BindingAdapter("text_html")
fun setText(tv: TextView, text: String) {
    tv.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("name_trip")
fun setNameTrip(tv: TextView, passenger: Passenger) {
    tv.text = "${passenger.name}, ${passenger.trips} Trips"
}

