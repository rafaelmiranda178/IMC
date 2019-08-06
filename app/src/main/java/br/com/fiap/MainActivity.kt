package br.com.fiap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            val proximaTela = Intent(this, ResultadoActivity::class.java)
            proximaTela.putExtra("PESO", edtPeso.text.toString())
            proximaTela.putExtra("ALTURA", edtAltura.text.toString())
            proximaTela.putExtra("SEXO", spnSexo.selectedItem.toString())
            startActivity(proximaTela)
        }

        btnLimpar.setOnClickListener {
            edtPeso.setText("")
            edtAltura.setText("")
            spnSexo.setSelection(0)
        }

    }
}
