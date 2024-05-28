package com.projeto.teste2.LoginCadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.projeto.teste2.databinding.ActivityTelacadastro1Binding

class telacadastro1 : AppCompatActivity() {
    private lateinit var binding: ActivityTelacadastro1Binding

    private val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelacadastro1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            voltarTeladelogin.setOnClickListener {
                val intent = Intent(this@telacadastro1, teladelogin::class.java)
                startActivity(intent)
            }

            continuar.setOnClickListener {
                val cadastro1 = hashMapOf(
                    "Nome completo" to nomecadastroedit.toString(),
                    "Telefone" to editTextPhone.toString().toInt(),
                    "Email" to editTextTextEmailAddress2.toString(),
                    "Senha" to editTextTextPassword2.toString(),
                    "Confirmação de senha" to editTextTextPassword3.toString()
                )
                db.collection("Cadastro Tela 1")
                    .add(cadastro1)
                    .addOnSuccessListener{
                        Toast.makeText(this@telacadastro1,"Deu certo!", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this@telacadastro1,"Deu errado!", Toast.LENGTH_SHORT).show()
                }

                /* if(binding.nomecadastroedit.text.toString().isNotEmpty()
                     && binding.editTextPhone.text.toString().isNotEmpty()
                     && binding.editTextTextEmailAddress2.text.toString().isNotEmpty()
                     && binding.editTextTextPassword2.text.toString().isNotEmpty()
                     && binding.editTextTextPassword3.text.toString().isNotEmpty()){

                     val nome = binding.nomecadastroedit.text.toString()*/

                val intent = Intent(this@telacadastro1, teladecadastro2::class.java)
                //intent.putExtra("nome", nome)
                startActivity(intent)
                return@setOnClickListener }
            /* else {
                 val messageCheckBox =
                     "O campo está vazio. Marque os termos de Uso."
                 val toast = Toast.makeText(this, messageCheckBox, Toast.LENGTH_SHORT)
                 toast.show()
             }
            validar()
             val intent = Intent(this, telacadastro2::class.java)
             startActivity(intent)


             binding.nomecadastroedit.text.toString().isNotEmpty()
                 && binding.editTextPhone.text.toString().isNotEmpty()
                 &&  binding.editTextTextEmailAddress2.text.toString().isNotEmpty()
                 && binding.editTextTextPassword2.text.toString().isNotEmpty()
                 && binding.editTextTextPassword3.text.toString().isNotEmpty()
         }*/
        }

        /* private fun validar() {
             val nome = binding.nomecadastroedit.text.toString()
             val telefone = binding.editTextPhone.text.toString()
             val email = binding.editTextTextEmailAddress2.text.toString()
             val senha = binding.editTextTextPassword2.text.toString()
             val repetesenha = binding.editTextTextPassword3.text.toString()

             val duration = Toast.LENGTH_SHORT
             if (nome.isEmpty()) {
                 val messageNome = "O campo está vazio. Insira seu nome antes de continuar."
                 val toast = Toast.makeText(this, messageNome, duration)
                 toast.show()
             }

             if (telefone.isEmpty()) {
                 val messageTelefone =
                     "O campo está vazio. Insira seu número de telefone antes de continuar."
                 val toast = Toast.makeText(this, messageTelefone, duration)
                 toast.show()
             }
             if (email.isEmpty()) {
                 val messageEmail =
                     "O campo está vazio. Insira seu email antes de continuar."
                 val toast = Toast.makeText(this, messageEmail, duration)
                 toast.show()
             }
             if (senha.isEmpty()) {
                 val messageSenha =
                     "O campo está vazio. Insira sua senha antes de continuar."
                 val toast = Toast.makeText(this, messageSenha, duration)
                 toast.show()
             }
             if (repetesenha.isEmpty()) {
                 val messageRepetesenha =
                     "O campo está vazio. Insira sua senha novamente antes de continuar."
                 val toast = Toast.makeText(this, messageRepetesenha, duration)
                 toast.show()
             }
         }
     }*/
        }
}