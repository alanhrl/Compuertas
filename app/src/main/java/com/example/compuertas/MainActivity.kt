package com.example.compuertas

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageButton
import android.widget.Toast
import com.example.compuertas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var entrada1 = 0
        var entrada2 = 0

        binding.etEntrada2.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                //habilitar boton si hay ambas entradas
                binding.btnCalcular.isEnabled = validaEntradas()
            }
        })
        binding.btnOR.setOnClickListener {
            toqueUnBoton(binding.btnOR, getString(R.string.compOR), getDrawable(R.drawable.compor))
            binding.btnCalcular.setOnClickListener{
                if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                    entrada1 = binding.etEntrada1.text.toString().toInt()
                    entrada2 = binding.etEntrada2.text.toString().toInt()
                    binding.tvResultado.text = compOR(entrada1, entrada2)
                }else{
                    if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                        error1()
                    }else if(binding.etEntrada1.text.isEmpty()){
                        error2()
                    }else{
                        error3()
                    }
                }
            }
        }

        binding.btnNOR.setOnClickListener {
            toqueUnBoton(binding.btnNOR, getString(R.string.compNOR), getDrawable(R.drawable.compnor))
            binding.btnCalcular.setOnClickListener{
                if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                    entrada1 = binding.etEntrada1.text.toString().toInt()
                    entrada2 = binding.etEntrada2.text.toString().toInt()
                    binding.tvResultado.text = compNOR(entrada1, entrada2)
                }else{
                    if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                        error1()
                    }else if(binding.etEntrada1.text.isEmpty()){
                        error2()
                    }else{
                        error3()
                    }
                }
            }
        }

        binding.btnXOR.setOnClickListener {
            toqueUnBoton(binding.btnXOR, getString(R.string.compXOR), getDrawable(R.drawable.compxor))
            binding.btnCalcular.setOnClickListener{
                if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                    entrada1 = binding.etEntrada1.text.toString().toInt()
                    entrada2 = binding.etEntrada2.text.toString().toInt()
                    binding.tvResultado.text = compXOR(entrada1, entrada2)
                }else{
                    if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                        error1()
                    }else if(binding.etEntrada1.text.isEmpty()){
                        error2()
                    }else{
                        error3()
                    }
                }
            }
        }

        binding.btnXNOR.setOnClickListener {
            toqueUnBoton(binding.btnXNOR, getString(R.string.compXNOR), getDrawable(R.drawable.compxnor))
            binding.btnCalcular.setOnClickListener{
                if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                    entrada1 = binding.etEntrada1.text.toString().toInt()
                    entrada2 = binding.etEntrada2.text.toString().toInt()
                    binding.tvResultado.text = compXNOR(entrada1, entrada2)
                }else{
                    if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                        error1()
                    }else if(binding.etEntrada1.text.isEmpty()){
                        error2()
                    }else{
                        error3()
                    }
                }
            }
        }

        binding.btnAND.setOnClickListener {
            toqueUnBoton(binding.btnAND, getString(R.string.compAND), getDrawable(R.drawable.compand))
            binding.btnCalcular.setOnClickListener{
                if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                    entrada1 = binding.etEntrada1.text.toString().toInt()
                    entrada2 = binding.etEntrada2.text.toString().toInt()
                    binding.tvResultado.text = compAND(entrada1, entrada2)
                }else{
                    if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                        error1()
                    }else if(binding.etEntrada1.text.isEmpty()){
                        error2()
                    }else{
                        error3()
                    }
                }
            }
        }


        binding.btnCalcular.setOnClickListener{
            if(binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()){
                entrada1 = binding.etEntrada1.text.toString().toInt()
                entrada2 = binding.etEntrada2.text.toString().toInt()
                binding.tvResultado.text = compAND(entrada1, entrada2)
            }else{
                if (binding.etEntrada1.text.isEmpty() && binding.etEntrada2.text.isEmpty()){
                    error1()
                }else if(binding.etEntrada1.text.isEmpty()){
                    error2()
                }else{
                    error3()
                }

            }

        }

    }

    fun compAND(ent1: Int, ent2: Int): String{
        if(ent1 == 1 && ent2 == 1) {
            return getString(R.string.log_uno)
        } else{
            return getString(R.string.log_cero)
        }
    }

    fun compOR(ent1: Int, ent2: Int): String{
        if(ent1 == 1 || ent2 == 1) {
            return getString(R.string.log_uno)
        } else{
            return getString(R.string.log_cero)
        }
    }

    fun compNOR(ent1: Int, ent2: Int): String{
        if(ent1 == 0 && ent2 == 0) {
            return getString(R.string.log_uno)
        } else{
            return getString(R.string.log_cero)
        }
    }

    fun compXOR(ent1: Int, ent2: Int): String{
        if((ent1 == 1 && ent2 == 0)||(ent1 == 0 && ent2 == 1)) {
            return getString(R.string.log_uno)
        } else{
            return getString(R.string.log_cero)
        }
    }
    fun compXNOR(ent1: Int, ent2: Int): String{
        if((ent1 == 1 && ent2 == 1)||(ent1 == 0 && ent2 == 0)) {
            return getString(R.string.log_uno)
        } else{
            return getString(R.string.log_cero)
        }
    }


    fun error1(){
        binding.etEntrada1.error = getString(R.string.requiere_numero)
        binding.etEntrada2.error = getString(R.string.requiere_numero)
        Toast.makeText(this, getString(R.string.requiere_entradas), Toast.LENGTH_LONG)
    }
    fun error2(){
        binding.etEntrada1.error = getString(R.string.requiere_numero)
        Toast.makeText(this, getString(R.string.requiere_entradas), Toast.LENGTH_LONG)
    }
    fun error3(){
        binding.etEntrada2.error = getString(R.string.requiere_numero)
        Toast.makeText(this, getString(R.string.requiere_entradas), Toast.LENGTH_LONG)
    }

    fun validaEntradas(): Boolean = binding.etEntrada1.text.isNotEmpty() && binding.etEntrada2.text.isNotEmpty()

    fun toqueUnBoton(botonpicado: ImageButton, tipoCompuerta: String, imgComp: Drawable?){
        val botones = listOf(binding.btnAND, binding.btnOR, binding.btnNOR, binding.btnXOR, binding.btnXNOR)

        for (i in botones){
            if(i!=botonpicado){
                i.setColorFilter(R.color.btn_copmuerta_color)//cambiar los ImageButton por Imageview
            }else{
                i.setColorFilter(R.color.btn_color_estado)
            }
        }
        binding.tvTitulo.text = tipoCompuerta
        binding.imvCompuerta.setImageDrawable(imgComp)

    }

}