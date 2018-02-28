package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.imc.extensions.format
import kotlinx.android.synthetic.main.activity_resultado.*
import java.net.IDN

class ResultadoActivity : AppCompatActivity() {

    fun setaImagem(resourceId: Int){
        ivStatusIMC.setImageDrawable(
                ContextCompat.getDrawable(this, resourceId))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        if(intent.extras != null){
            val peso = intent.getStringExtra("Peso").toDouble()

            val altura = intent.getStringExtra("Altura").toDouble()

            val calculoIMC : Double = peso / (altura * altura)

            tvIMC.text = calculoIMC.format(1)

            if(calculoIMC < 18.5){
                tvStatusIMC.text = "Abaixo do Peso"
                setaImagem(R.drawable.abaixo)
            }
            else if(calculoIMC > 18.6 && calculoIMC < 24.9){
                    tvStatusIMC.text = "Peso Ideal"
                    setaImagem(R.drawable.ideal)
            }
            else if(calculoIMC > 25.0 && calculoIMC < 29.9){
                tvStatusIMC.text = "Levemente Acima do Peso"
                setaImagem(R.drawable.sobre)
            }
            else if(calculoIMC > 30.0 && calculoIMC < 34.9) {
                tvStatusIMC.text = "Obesidade"
                setaImagem(R.drawable.obesidade)
            }
            else if(calculoIMC > 35.0 && calculoIMC < 39.9) {
                tvStatusIMC.text = "Obesidade"
                setaImagem(R.drawable.obesidade)
            } else {
                tvStatusIMC.text = "Obesidade"
                setaImagem(R.drawable.obesidade)
            }
        }
    }
}
