package com.example.projetokn.presenter


import com.example.projetokn.model.Usuariomodel
import com.example.projetokn.presenter.banco.configuracaobanco
import com.example.projetokn.utilidade.Util

class Usuariopresenter {
    var bd = configuracaobanco.getconexaousuario()


    fun CadastrarUsuario(user: Usuariomodel) {

        bd.createUserWithEmailAndPassword(user.login.toString(), user.senha.toString())

    }//fim classe

    fun RedefinirSenha(email: String) {
       bd.sendPasswordResetEmail(email)
    }
}