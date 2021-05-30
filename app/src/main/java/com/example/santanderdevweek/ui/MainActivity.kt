package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.TextureView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tb_toolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    fun bindOnView(conta: Conta) {
        findViewById<TextView>(R.id.tv_usuario).text = "${conta.cliente.nome}"
        findViewById<TextView>(R.id.tv_agencia).text = "Ag ${conta.agencia}"
        findViewById<TextView>(R.id.tv_conta_corrente).text = "Cc ${conta.numero}"
        findViewById<TextView>(R.id.tv_saldo).text = "${conta.saldo}"
        findViewById<TextView>(R.id.tv_saldo_limite_valor).text = "${conta.limite}"
        findViewById<TextView>(R.id.tv_cartao_value).text = "${conta.cartao.numeroCartao}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.m_bell -> {
                Log.d("CLICK", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}