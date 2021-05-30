package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        val cliente = Cliente("Filipe")
        val cartao = Cartao("4165")
        return Conta(
            "21565-4",
            "4592",
            "R$ 2.450,87",
            "R$ 3.450,87",
            cliente,
            cartao
        )
    }
}