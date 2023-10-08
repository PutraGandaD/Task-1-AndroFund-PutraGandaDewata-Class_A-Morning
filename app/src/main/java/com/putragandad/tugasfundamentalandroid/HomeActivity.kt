package com.putragandad.tugasfundamentalandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDetailAkun: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        title = "Beranda"

        tvDetailAkun = findViewById(R.id.tv_detail_akun)
        val email = intent.getParcelableExtra<User>("User")?.email
        val password = intent.getParcelableExtra<User>("User")?.password
        tvDetailAkun.text = "Email Anda : $email \n Password Anda : $password"

        val btnLogout: Button = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_logout -> {
                val intent = Intent()
                intent.putExtra("riwayatLogin", "Anda Sudah Login")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}