package com.example.projetokn.presenter

import android.content.Context
import android.view.View
import com.example.projetokn.model.Pessoamodel
import com.example.projetokn.presenter.banco.configuracaobanco
import com.example.projetokn.utilidade.Util

class Pessoapresenter(context: Context) {
    var cont = context
    var banco = configuracaobanco.getconexaofirestore()
    fun CadastrarPessoa(v: View, pessoamodel: Pessoamodel){

        banco.collection("Pessoa").document(pessoamodel.cpf.toString()).get()
            .addOnSuccessListener { sucesso ->
                if(sucesso.exists()){
                    Util.ExibirMensagemSnackbar(v,"CPF EXISTENTE")
                }else{
                    banco.collection("Pessoa").document(pessoamodel.cpf.toString()).set(pessoamodel)
                    Util.ExibirMensagemSnackbar(v,"Dados Cadastrados...")
                }
            }.addOnFailureListener{ error->

            }

    }
}