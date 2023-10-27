package com.example.parqueadero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class NuevaReservaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_reserva)

        val btnNext=findViewById<Button>(R.id.btn_Siguiente)
        val btnConfirm=findViewById<Button>(R.id.btn_Confirmar)
        val cvNetx=findViewById<CardView>(R.id.cv_siguiente)
        val cvConfirm=findViewById<CardView>(R.id.cv_confirmar)

        btnNext.setOnClickListener{
            cvNetx.visibility= View.GONE
            cvConfirm.visibility= View.VISIBLE
        }
        btnConfirm.setOnClickListener{
            Toast.makeText(applicationContext,"Reserva realizada exitoamente", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}