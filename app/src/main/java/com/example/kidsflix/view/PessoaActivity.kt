package com.example.kidsflix.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kidsflix.R
import com.example.kidsflix.databinding.ActivityPessoaBinding
import com.example.projetokn.model.Pessoamodel
import com.example.projetokn.presenter.Pessoapresenter
import com.example.projetokn.presenter.banco.configuracaobanco
import com.example.projetokn.utilidade.Util

class PessoaActivity : AppCompatActivity(), View.OnClickListener  {
    lateinit var bind: ActivityPessoaBinding
    var pessoamodel = Pessoamodel()
    var pessoapresenter = Pessoapresenter(this)
    var bd = configuracaobanco.getconexaofirestore()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessoa)
        bind = ActivityPessoaBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btsalvar.setOnClickListener(this)
        bind.btpesquisar.setOnClickListener(this)
        bind.btalterar.setOnClickListener(this)
        bind.btexcluir.setOnClickListener(this)
    }
    override fun onClick(v: View?){
        when(v?.id){
            bind.btsalvar.id ->{
                pessoamodel.nome = bind.edtnome.text.toString()
                pessoamodel.cpf = bind.edtcpf.text.toString()
                pessoamodel.ano = bind.edtano.text.toString().toIntOrNull()
                pessoapresenter.CadastrarPessoa(findViewById(R.id.layoutpessoa),pessoamodel)
            }//fim salvar
            bind.btpesquisar.id ->{
                var cpfpesq = bind.edtcpf.text.toString()
                bd.collection("Pessoa").document(cpfpesq).get()
                    .addOnSuccessListener { sucesso ->
                        var pessoa = sucesso.toObject(Pessoamodel::class.java)
                        var idade = (2021-Integer.parseInt(pessoa?.ano.toString()))
                        bind.txtnome.text = pessoa?.nome.toString()
                        bind.txtcpf.text = pessoa?.cpf.toString()
                        bind.txtano.text = pessoa?.ano.toString()
                        bind.txtidade.text = idade.toString()
                    }.addOnFailureListener { error ->

                    }
            }
            bind.btalterar.id ->{

                var cpfpesq = bind.edtcpf.text.toString()
                var pessoa = Pessoamodel()
                pessoa.nome = bind.edtnome.text.toString()
                pessoa.cpf = bind.edtcpf.text.toString()
                pessoa.ano = bind.edtano.text.toString().toInt()
                var dado = hashMapOf<String,Any>("nome" to pessoa.nome.toString(),"ano" to pessoa.ano.toString().toInt())
                bd.collection("Pessoa").document(pessoa.cpf.toString()).update(dado)

            }
            bind.btexcluir.id->{
                var cpfpesq = bind.edtcpf.text.toString()
                bd.collection("Pessoa").document(cpfpesq).delete()
                    .addOnSuccessListener {
                        Util.ExibirMensagemToast(this,"Excluido com sucesso")
                    }.addOnFailureListener {
                        Util.ExibirMensagemToast(this,"Falha ao excluir")
                    }
            }
        }
    }
}