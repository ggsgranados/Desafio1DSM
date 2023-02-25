package com.example.tallerpractico1dsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PromedioNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio_notas)

        val nombre = findViewById<EditText>(R.id.txtEstudiante)
        val nota1 = findViewById<EditText>(R.id.txtNota1)
        val nota2 = findViewById<EditText>(R.id.txtNota2)
        val nota3 = findViewById<EditText>(R.id.txtNota3)
        val nota4 = findViewById<EditText>(R.id.txtNota4)
        val nota5 = findViewById<EditText>(R.id.txtNota5)
        val button = findViewById<Button>(R.id.btnPromedio)
        val tvPromedio = findViewById<TextView>(R.id.tvPromedio)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        var auxPromedio: Double

        button.setOnClickListener {
            try {
                if (nota1.text.toString().toDouble() in 0.0..10.0 &&
                    nota2.text.toString().toDouble() in 0.0..10.0 &&
                    nota3.text.toString().toDouble() in 0.0..10.0 &&
                    nota4.text.toString().toDouble() in 0.0..10.0 &&
                    nota5.text.toString().toDouble() in 0.0..10.0 &&
                    !nombre.text.isNullOrBlank()
                ) {

                    auxPromedio = (nota1.text.toString().toDouble() +
                            nota2.text.toString().toDouble() +
                            nota3.text.toString().toDouble() +
                            nota4.text.toString().toDouble() +
                            nota5.text.toString().toDouble()) / 5

                    tvPromedio.text =
                        "Nombre: ${nombre.text}\n" +
                                "Promedio: ${String.format("%.2f", auxPromedio)}\n"
                    if (auxPromedio >= 6.0)
                        tvResultado.text = "Ha aprobado la asignatura"
                    else
                        tvResultado.text = "Ha reprobado la asignatura"
                } else
                    Toast.makeText(this, "Los campos son incorrectos o nulos", Toast.LENGTH_LONG)
                        .show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_LONG).show()
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
            Toast.makeText(this, "Se seleccionó la primer opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, PromedioNotas::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "Se seleccionó la segunda opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SalarioNeto::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "Se seleccionó la tercer opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}