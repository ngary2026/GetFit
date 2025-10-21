package com.example.bitfit

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var empty: TextView
    private lateinit var fab: FloatingActionButton
    private val adapter = WorkoutAdapter(onClick = { /* open detail */ })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rvWorkouts)
        empty = findViewById(R.id.tvEmptyState)
        fab = findViewById(R.id.fabAddWorkout)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        // Temporary fake data to see the UI:
        val demo = listOf(
            WorkoutUi("Chest Day", "Oct 15, 2025", 6),
            WorkoutUi("Leg Day", "Oct 13, 2025", 5),
            WorkoutUi("Pull Day", "Oct 10, 2025", 7),
        )
        render(demo)

        fab.setOnClickListener {
            // TODO: navigate to NewWorkout screen
        }
    }

    private fun render(items: List<WorkoutUi>) {
        adapter.submit(items)
        empty.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
    }
}