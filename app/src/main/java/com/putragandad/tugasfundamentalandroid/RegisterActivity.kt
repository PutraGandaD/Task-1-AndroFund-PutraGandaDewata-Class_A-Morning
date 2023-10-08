package com.putragandad.tugasfundamentalandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etNama:EditText
    private lateinit var etEmail:EditText
    private lateinit var etAlamat:EditText
    private lateinit var etPassword:EditText
    private lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.et_nama_register)
        etEmail = findViewById(R.id.et_email_register)
        etAlamat = findViewById(R.id.et_alamat_register)
        etPassword = findViewById(R.id.et_password_register)
        etConfirmPassword = findViewById(R.id.et_confpassword_register)

        val btnDaftar: Button = findViewById(R.id.btn_register_data)
        btnDaftar.setOnClickListener(this)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Daftar"
    }

    override fun onClick(v: View) {
        when(v.id) {

            R.id.btn_register_data -> {
                val bundle = Bundle()
                bundle.putString("email", etEmail.text.toString())
                bundle.putString("namalengkap", etNama.text.toString())
                bundle.putString("alamat", etAlamat.text.toString())
                bundle.putString("password", etPassword.text.toString())
                bundle.putString("konfirmasipassword", etConfirmPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}