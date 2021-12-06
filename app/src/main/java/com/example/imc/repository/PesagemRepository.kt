package com.example.imc.repository

import android.content.Context
import com.example.imc.model.Pesagem

// retorna uma lista com o histórico de pesagens do usuário
class PesagemRepository(var context: Context) {

    fun getListaPesagem(): List<Pesagem> {
        val listaPesagem = mutableListOf<Pesagem>()

        // ** Preencher a lista de pesagem
        val dados = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val pesosString = dados.getString("pesagem", "")
        // 72;68;68
        val pesos = pesosString!!.split(";").toTypedArray()

        val datasString = dados.getString("data_pesagem", "")
        // 2021-11-29;2021-12-06;2021-12-06
        val datas = datasString!!.split(";").toTypedArray()

        // ** Lista de pesagem
        // atribui sequencialmente à variável 'peso' um valor diferente a cada volta
        for (i in 0 until pesos.size) {
            val pesagem = Pesagem(datas[i], pesos[i].toInt())
            listaPesagem.add(pesagem)
        }

        return listaPesagem
    }

}