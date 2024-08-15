 package com.maya.emergencyapplication

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
        val emergencies = arrayListOf<Emergency>()
        emergencies.add(Emergency(R.drawable.hospital, getString(R.string.ambulance), "123"))
        emergencies.add(Emergency(R.drawable.fire, getString(R.string.fire), "180"))
        emergencies.add(Emergency(R.drawable.police, getString(R.string.police), "122"))

        val adapter = EmergencyAdapter(this, emergencies)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.adapter=adapter
    }

     override fun onBackPressed() {
         val exit = ExitDialog()
         exit.isCancelable = false
         exit.show(supportFragmentManager, null)
     }
}