package com.example.kidsflix.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kidsflix.databinding.ActivityLoginBinding
import com.example.projetokn.presenter.banco.configuracaobanco
import com.example.projetokn.utilidade.Util

    class LoginActivity : AppCompatActivity() {
        lateinit var bind: ActivityLoginBinding
        var bd = configuracaobanco.getconexaousuario()
        var util = Util

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            bind = ActivityLoginBinding.inflate(layoutInflater)

            bind.btcriarconta.setOnClickListener {
                startActivity(Intent(this, CadastrarUsuarioActivity::class.java))
                finish()
            }

            bind.btlogin.setOnClickListener {

                login(bind.edtlogin.text.toString(), bind.edtsenha.text.toString(), this)

            }


            bind.btredefinirsenha.setOnClickListener {
                startActivity(Intent(this, RedefinirSenhaActivity::class.java))

            }

            setContentView(bind.root)
        }


        fun login(login: String, senha: String, context: Context) {

            bd.signInWithEmailAndPassword("$login", "$senha")

                .addOnSuccessListener { sucesso ->
                    var intent = Intent(context, HomeActivity::class.java)
                    startActivity(intent)
                }.addOnFailureListener { error ->
                    util.ExibirMensagemToast(context, "Email/Senha não cadastrado")
                    bind.edtlogin.text?.clear()
                    bind.edtsenha.text?.clear()
                    bind.edtlogin.requestFocus()
                }

        }
    }
