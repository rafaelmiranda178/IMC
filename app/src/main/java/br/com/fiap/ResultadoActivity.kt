package br.com.fiap

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*
import java.text.DecimalFormat
import java.text.NumberFormat

class ResultadoActivity : AppCompatActivity() {

    var peso = 0.0
    var altura = 0.0
    var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        carregaDados()
        calcular()

    }

    @SuppressLint("SetTextI18n")
    private fun calcular() {
        val imc = peso / (altura * altura)
//        val dec = DecimalFormat("#,###.#")


//        txvResultado.text = dec.format(imc)
        txvResultado.text = imc.toFixed(1)


        when {
            imc < 18.5 -> {
                txvMensagemResultado.text = getString(R.string.abaixo_peso)
                setaImagem(R.drawable.fem_abaixo)
            }
            imc < 24.9 -> {
                txvMensagemResultado.text = "Peso ideal"
                setaImagem(R.drawable.fem_ideal)
            }
            imc < 29.9 -> {
                txvMensagemResultado.text = "Levemente acima do peso"
                setaImagem(R.drawable.fem_sobre)
            }
            imc < 34.9 -> {
                txvMensagemResultado.text = "Obeso"
                setaImagem(R.drawable.fem_obeso)
            }
            else -> {
                txvMensagemResultado.text = "Extremamente Obeso"
                setaImagem(R.drawable.fem_extremo_obeso)
            }
        }


    }

    fun setaImagem(resourceId: Int) {
        imvResultado.setImageDrawable(
            ContextCompat.getDrawable(this,
                resourceId))
    }


    private fun carregaDados() {
        peso = intent.getStringExtra("PESO").toDouble()
        altura = intent.getStringExtra("ALTURA").toDouble()
        sexo = intent.getStringExtra("SEXO")
    }


}
