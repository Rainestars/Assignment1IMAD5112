package com.example.imad5112_icetask12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Should declare UI elements:

    lateinit var inputTime: EditText
    lateinit var buttonSubmit: Button
    lateinit var buttonClear: Button
    lateinit var outputSparks: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initializing UI elements:

        inputTime = findViewById(R.id.inputTime)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonClear = findViewById(R.id.buttonClear)
        outputSparks = findViewById(R.id.outputSpark)

        // Submit Button function

        buttonSubmit.setOnClickListener {
           val timeOfDay = inputTime.text.toString().trim().lowercase()

            val suggestion = when (timeOfDay) {
                "morning" -> "Send a 'Good morning' text to a family member."
                "mid-morning" -> "Reach out to a colleague with a quick 'Thank you'."
                "afternoon" -> "Share a funny meme or interesting link with a friend."
                "afternoon snack time" -> "Send a quick 'Thinking of you' message."
                "dinner" -> "Call a friend or relative for a 5-minute catch-up."
                "after dinner/night" -> "Leave a thoughtful comment on a friend's post."
                else -> null
            }
            // Display for either an error or suggestion

            if (suggestion != null){
                outputSparks.text=suggestion
        }
            else{
                outputSparks.text="Please a valid time of day! (e.g. Morning)"
            }
        }
        // Clear Button function

        buttonClear.setOnClickListener {
            val editTexts = listOf(inputTime, outputSparks)
            editTexts.forEach { it.setText("") }
        }
    }
}
