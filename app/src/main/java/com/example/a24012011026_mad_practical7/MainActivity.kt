package com.example.a24012011026_mad_practical7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val arrayList = arrayOf(
            Contact("PG1" , "9426155466" , "shreejipdg@gmail.com" , "452EFWKOQKTPGAGMOFWA"),
            Contact("PG2" , "9265358393", "kavyaraval@gmail.com" , "5521SDOKFOWKAPRAGGT"),
            Contact("PG3" , "8780933771", "riddhisiddhi@gmail.com" , "582feplwlFAI4OWpet")
        )

        val rv = findViewById<RecyclerView>(R.id.recycle1)
//      rv.layout()
        rv.adapter = Contact_adpter(arrayList)

    }
}
