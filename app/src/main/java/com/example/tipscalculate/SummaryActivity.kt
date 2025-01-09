package com.example.tipscalculate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculate.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 0)
        val totalWthTips = intent.getFloatExtra("totalWthTips", 0.0f)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalTips = intent.getFloatExtra("totalTips", 0.0f)

        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeople.text = numPeople.toString()
        binding.tvTotalWthTips.text = totalWthTips.toString()
        binding.tvPercentage.text = percentage.toString()
        binding.tvTotaltips.text = totalTips.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }

    }
}