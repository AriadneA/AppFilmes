package com.example.projetokn.utilidade

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Util {
    companion object{

        fun ExibirMensagemToast(context:Context,mensagem:String){
            Toast.makeText(context,mensagem,Toast.LENGTH_LONG).show()
        }//fim exibir
        fun ExibirMensagemSnackbar(v: View, mensagem:String){
            Snackbar.make(v,mensagem,Snackbar.LENGTH_LONG).show()
        }

    }//fim object

}//fim classe util