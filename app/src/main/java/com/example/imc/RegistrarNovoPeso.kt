package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imc.utils.convertStringToLocalDate
import java.time.LocalDate

class RegistrarNovoPeso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_novo_peso)

        var dataPesagem = findViewById<TextView>(R.id.tv_dataPesagem)

//        var dataDesformatada = LocalDate.now().toString()
//
//        var dataFormatada = convertStringToLocalDate(dataDesformatada)

        var dataHoje = LocalDate.now().toString()
        var dataHojeArray = dataHoje.split("-").toTypedArray()
        dataPesagem.text = dataHojeArray[2] + "/" + dataHojeArray[1]  + "/" + dataHojeArray[0]

//        var dataPesagemConvertida = d
    }
}