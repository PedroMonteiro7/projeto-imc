package com.example.imc.model

import java.time.LocalDate

data class Usuario(
        var id: Int,
        var nome: String,
        var email: String,
        var senha: String,
        var peso: Int,
        var altura: Double,
        var dataNascimento: LocalDate,
        var profissao: String,
        var sexo: Char,
        var fotoPerfil: String
)
