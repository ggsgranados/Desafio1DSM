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

class SalarioNeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario_neto)

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val salario = findViewById<EditText>(R.id.txtSalario)
        val button = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.textViewResultado)

        button.setOnClickListener {
            try {
                if (salario.text.toString().toDouble() > 0.0 && !nombre.text.isNullOrBlank()) {
                    tvResultado.text =
                        "Nombre: ${nombre.text} \n" +
                                "ISSS: \$${
                                    String.format(
                                        "%.2f",
                                        salario.text.toString().toDouble() * 0.03
                                    )
                                }\n" +
                                "AFP: \$${
                                    String.format(
                                        "%.2f",
                                        salario.text.toString().toDouble() * 0.04
                                    )
                                }\n" +
                                "Renta: \$${
                                    String.format(
                                        "%.2f",
                                        salario.text.toString().toDouble() * 0.05
                                    )
                                }\n" +
                                "Total de descuentos: \$${
                                    String.format(
                                        "%.2f",
                                        salario.text.toString().toDouble() * 0.12
                                    )
                                }\n" +
                                "SALARIO NETO: \$${
                                    String.format(
                                        "%.2f",
                                        salario.text.toString().toDouble() * 0.88
                                    )
                                }"
                } else
                    Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show()

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