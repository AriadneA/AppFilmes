package com.example.kidsflix.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidsflix.R
import com.example.kidsflix.databinding.ActivityCadastrarUsuarioBinding
import com.example.projetokn.model.Usuariomodel
import com.example.projetokn.presenter.Usuariopresenter
import com.example.projetokn.utilidade.Util

class CadastrarUsuarioActivity : AppCompatActivity() {
    lateinit var bind: ActivityCadastrarUsuarioBinding
    var usermodel = Usuariomodel()
    var userpresenter = Usuariopresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCadastrarUsuarioBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btcadastrar.setOnClickListener {
            if (ValidarCampos()) {
                usermodel.login = bind.edtemail.text.toString()
                usermodel.senha = bind.edtsenha.text.toString().toIntOrNull()
                userpresenter.CadastrarUsuario(usermodel)
                Util.ExibirMensagemToast(this,"Cadastrado com sucesso!")
                startActivity(Intent(this,PessoaActivity::class.java))
            }else{
                Util.ExibirMensagemToast(this,"Preencha os campos necessarios")
            }
        }
        bind.btvoltarC.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
    fun ValidarCampos():Boolean {
        if (!bind.edtemail.text.toString().isEmpty() && !bind.edtsenha.text.toString().isEmpty()) {
            return true
        } else{
            return false
        }
    }

}