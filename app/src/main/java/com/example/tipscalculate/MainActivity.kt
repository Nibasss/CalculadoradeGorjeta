package com.example.tipscalculate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculate.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var percentage: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieNumberOfPeople.text
            if (totalTableTemp?.isEmpty() == true || numPeopleTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieTotal, "Preencha Todos Os Campos", Snackbar.LENGTH_LONG)
                    .show()
            } else if (percentage == 0) {
                Snackbar.make(
                    binding.tieTotal,
                    "Selecione uma porcentagem para a gorjeta",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val numPeople: Int = numPeopleTemp.toString().toInt()
                val totalTemp = totalTable / numPeople
                val tips = totalTable * percentage / 100
                val totalTips = tips
                val totalWthTips = totalTable + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", numPeople)
                    putExtra("totalWthTips", totalWthTips)
                    putExtra("percentage", percentage)
                    putExtra("totalTips", totalTips)

                }
                clean()
                startActivity(intent)
            }
        }
        binding.btnClean.setOnClickListener {
            clean()

        }
    }

    private fun clean() {
        binding.tieTotal.setText("")
        binding.tieNumberOfPeople.setText("")
        binding.rbOptionOne.isChecked = false
        binding.rbOptionTwo.isChecked = false
        binding.rbOptionThree.isChecked = false
        percentage = 0

    }
}