package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imc.utils.getDataAtualBrasil
import java.time.LocalDate

class PesoActivity : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView
    lateinit var etNovoPeso: EditText
    lateinit var spinnerNivel: Spinner
    lateinit var btnRegistrarNovoPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)
        supportActionBar!!.hide()

        tvDataPesagem = findViewById(R.id.tv_data_pesagem)
        etNovoPeso = findViewById(R.id.et_peso)
        spinnerNivel = findViewById(R.id.spinner_niveis)
        btnRegistrarNovoPeso = findViewById(R.id.btn_registrar_peso)

        tvDataPesagem.text = getDataAtualBrasil()

        btnRegistrarNovoPeso.setOnClickListener {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivelAtividade = arquivo.getString("nivel", "")

            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${etNovoPeso.text.toString().toString()}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nivel", "$nivelAtividade;${spinnerNivel.selectedItemPosition.toString()}")
            editor.apply()

            Toast.makeText(this, "Peso registrado com sucesso.", Toast.LENGTH_SHORT)
        }


    }
}