package com.example.parqueadero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tvGoLogin= findViewById<TextView>(R.id.tv_go_to_login)
        tvGoLogin.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            goToLogin()
        }
    }
    private fun goToLogin(){
        val i =Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}