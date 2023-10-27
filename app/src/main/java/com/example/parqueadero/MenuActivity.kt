package com.example.parqueadero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.parqueadero.util.PreferenceHelper
import com.example.parqueadero.util.PreferenceHelper.set

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnLogout =findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{
            clearSessionPreference()
            goToLogin()
        }
        val btnNuevaReserva = findViewById<Button>(R.id.btn_NuevaReserva)
        btnNuevaReserva.setOnClickListener{
            goToCreateNuevaReserva()
        }
    }
    private fun goToCreateNuevaReserva(){
        val i = Intent(this, NuevaReservaActivity::class.java)
        startActivity(i)
    }

    private fun goToLogin(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
    private fun clearSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"]=false


    }
}