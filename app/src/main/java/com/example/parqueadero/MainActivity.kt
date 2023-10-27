package com.example.parqueadero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.parqueadero.util.PreferenceHelper
import com.example.parqueadero.util.PreferenceHelper.get
import com.example.parqueadero.util.PreferenceHelper.set
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        val preferences = PreferenceHelper.defaultPrefs(this)
        if(preferences["session", false])
            goToMenu()


        val tvGoRegister = findViewById<TextView>(R.id.tv_go_to_register)
        tvGoRegister.setOnClickListener{
            goToRegister()
        }


        val btnGoMenu = findViewById<Button>(R.id.btn_iniciar)
        btnGoMenu.setOnClickListener {
            goToMenu()
        }

    }
    private fun goToRegister(){
        val i =Intent(this, RegisterActivity :: class.java)
        startActivity(i)
    }
    private fun goToMenu(){
        val i = Intent(this, MenuActivity::class.java)
        createSessionPreference()
        startActivity(i)
        finish()
    }
    private fun createSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"]=true
    }
    private fun showAler(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog=builder.create()
        dialog.show()
    }
    private fun showHome(correoElectronico:String, contraseña: ProviderType ){
        val homeIntent= Intent(this, RegisterActivity::class.java).apply {
            putExtra("email", correoElectronico)
            putExtra("Contraseña", contraseña)
        }
    }

}