package com.example.kidsflix.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidsflix.R
import com.example.kidsflix.databinding.ActivityRedefinirSenhaBinding
import com.example.projetokn.presenter.Usuariopresenter
import com.example.projetokn.utilidade.Util

class RedefinirSenhaActivity : AppCompatActivity() {
    var usuariopresenter = Usuariopresenter()
    lateinit var bind : ActivityRedefinirSenhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redefinir_senha)
        bind = ActivityRedefinirSenhaBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btenviar.setOnClickListener{
            usuariopresenter.RedefinirSenha(bind.edtemailred.text.toString())
            Util.ExibirMensagemToast(this,"Enviamos uma mensagem para seu email com um link para redefinir sua senha")
        }
        bind.btvoltarRS.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}