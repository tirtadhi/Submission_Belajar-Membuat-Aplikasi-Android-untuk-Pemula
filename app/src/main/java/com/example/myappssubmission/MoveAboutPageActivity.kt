package com.example.myappssubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MoveAboutPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_about_page)
        val profileImageView: ImageView = findViewById(R.id.profile_image)

        // Mengatur gambar dari resource drawable
        profileImageView.setImageResource(R.drawable.profil)

        // Untuk mendapatkan TextView
        val tvItemName = findViewById<TextView>(R.id.tv_item_name)
        val tvItemDescription = findViewById<TextView>(R.id.tv_item_description)

        // untuk mengatur nama
        tvItemName.text = "Tirta Adhi Samsara"
        tvItemDescription.text = "email@gmail.com"
    }
}
