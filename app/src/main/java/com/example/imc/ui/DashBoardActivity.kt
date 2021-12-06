package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.imc.PesoActivity
import com.example.imc.R
import com.example.imc.RegistrarNovoPeso
import com.example.imc.repository.PesagemRepository
import com.example.imc.utils.calcularIdade
import com.example.imc.utils.convertBase64ToBitmap

class DashBoardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView
    lateinit var cardNovaPesagem: CardView
    lateinit var cardHistorico: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val cardViewPesar = findViewById<CardView>(R.id.cardViewPesar)

        cardViewPesar.setOnClickListener {
            val pesarAgora = Intent(this, RegistrarNovoPeso::class.java)
            startActivity(pesarAgora)
        }

        cardViewPesar

        tvNome = findViewById(R.id.tv_dash_nome)
        tvNcd = findViewById(R.id.tv_dash_ncd)
        tvPeso = findViewById(R.id.tv_dash_peso)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvAltura = findViewById(R.id.tv_dash_altura)
        tvIdade = findViewById(R.id.tv_dash_idade)
        tvImc = findViewById(R.id.tv_dash_imc)
        ivPerfil = findViewById(R.id.iv_dash_foto_perfil)
        cardNovaPesagem = findViewById(R.id.cardViewPesar)
        cardHistorico = findViewById(R.id.card_historico)

        cardNovaPesagem.setOnClickListener {
            val intent = Intent(this, PesoActivity::class.java)
            startActivity(intent)
        }

        cardHistorico.setOnClickListener {

            val intent = Intent(this, HistoricoActivity::class.java)

//            val pesagemRepository = PesagemRepository(this)
//            val listaPesagem = pesagemRepository.getListaPesagem()
//
//            for (p in listaPesagem) {
//                Log.i("xpto", "${p.dataPesagem} - ${p.peso}")
//            }

            Toast.makeText(this, "teste", Toast.LENGTH_SHORT)
        }

        carregarDashboard()
    }

    private fun carregarDashboard() {
        val arquivo =
                getSharedPreferences(
                        "usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitmap)

    }
}