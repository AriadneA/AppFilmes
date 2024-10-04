package com.example.projetokn.presenter.banco

import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class configuracaobanco {
    companion object Conexao {

        var auth = Firebase.auth
        var banco = FirebaseFirestore.getInstance()

        fun getconexaousuario(): FirebaseAuth {


            if (auth==null){
                auth = Firebase.auth
                return auth
            }else{
                return auth
            }
        }
        fun getconexaofirestore(): FirebaseFirestore {

            if (banco==null){
                banco = FirebaseFirestore.getInstance()
                return banco
            }else{
                return banco
            }
        }
    }
}