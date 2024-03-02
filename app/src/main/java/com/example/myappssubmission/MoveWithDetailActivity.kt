package com.example.myappssubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MoveWithDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_detail)

        // Ambil data dari Intent
        val gadgetName = intent.getStringExtra("gadget_name")
        val gadgetDescription = intent.getStringExtra("gadget_description")
        val gadgetPhoto = intent.getStringExtra("gadget_photo")
        val gadgetDisplay = intent.getStringExtra("gadget_display")
        val gadgetBattery = intent.getStringExtra("gadget_battery")

        // Tampilkan data ke dalam komponen UI
        val tvItemName: TextView = findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = findViewById(R.id.tv_item_description)
        val imgItemPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvItemDisplay: TextView = findViewById(R.id.tv_item_display)
        val tvItemBattery: TextView = findViewById(R.id.tv_item_battery)

        // Set data ke dalam komponen UI
        tvItemName.text = gadgetName
        tvItemDescription.text = gadgetDescription
        tvItemDisplay.text = gadgetDisplay
        tvItemBattery.text = gadgetBattery

        // Tampilkan gambar menggunakan Glide
        Glide.with(this)
            .load(gadgetPhoto)
            .into(imgItemPhoto)
    }
}
