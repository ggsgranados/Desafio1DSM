package com.example.tallerpractico1dsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val lista = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1

        button.setOnClickListener {
            try {
                when (spinner.selectedItem.toString()) {
                    "Sumar" -> tv1.text = "Resultado: ${
                        et1.text.toString().toDouble() + et2.text.toString().toDouble()
                    }"
                    "Restar" -> tv1.text = "Resultado: ${
                        et1.text.toString().toDouble() - et2.text.toString().toDouble()
                    }"
                    "Multiplicar" -> tv1.text = "Resultado: ${
                        et1.text.toString().toDouble() * et2.text.toString().toDouble()
                    }"
                    "Dividir" ->
                        if (et2.text.toString().toDouble() != 0.0)
                            tv1.text = "Resultado: ${
                                et1.text.toString().toDouble() / et2.text.toString().toDouble()
                            }"
                        else
                            tv1.text = "Resultado: No se puede dividir entre cero (Indeterminado)"
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Los campos no pueden estar vac??os", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuopciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.opcion1) {
            Toast.makeText(this, "Se seleccion?? la primer opci??n", Toast.LENGTH_LONG).show()
            val intent = Intent(this, PromedioNotas::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "Se seleccion?? la segunda opci??n", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SalarioNeto::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "Se seleccion?? la tercer opci??n", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}