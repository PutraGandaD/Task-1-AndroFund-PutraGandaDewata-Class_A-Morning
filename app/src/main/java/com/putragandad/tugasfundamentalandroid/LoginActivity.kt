package com.putragandad.tugasfundamentalandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etEmail: EditText
    private lateinit var etPassword : EditText
    private lateinit var tvRiwayatLogin : TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("riwayatLogin")
            tvRiwayatLogin.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Masuk"

        tvRiwayatLogin = findViewById(R.id.tv_riwayat_login)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)

        val bundle = intent.extras
        if (bundle != null) {
            etEmail.setText(bundle.getString("email"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnMasuk: Button = findViewById(R.id.btn_login_data)
        btnMasuk.setOnClickListener(this)
    }

    override fun onClick(v:View) {
        when(v.id) {
            R.id.btn_login_data -> {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("User", User(etEmail.text.toString(), etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}