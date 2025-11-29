package com.example.bitfit

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class WorkoutUi(
    val id: Long,
    val name: String,
    val dateLabel: String,
    val exerciseCount: Int
)

class WorkoutAdapter(
    private var items: List<WorkoutUi> = emptyList(),
    private val onClick: (WorkoutUi) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.VH>() {

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        private val name = v.findViewById<TextView>(R.id.tvWorkoutName)
        private val meta = v.findViewById<TextView>(R.id.tvWorkoutMeta)
        @SuppressLint("SetTextI18n")
        fun bind(item: WorkoutUi) {
            name.text = item.name
            meta.text = "${item.dateLabel} • ${item.exerciseCount} exercises"
            itemView.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_workout, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size

    fun submit(list: List<WorkoutUi>) {
        items = list
        notifyDataSetChanged()
    }
}