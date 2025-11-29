package com.example.bitfit

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(
    private val items: MutableList<ExerciseUi> = mutableListOf()
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameEdit: EditText = itemView.findViewById(R.id.etExerciseName)
        private val setsEdit: EditText = itemView.findViewById(R.id.etSets)
        private val repsEdit: EditText = itemView.findViewById(R.id.etReps)

        private var nameWatcher: TextWatcher? = null
        private var setsWatcher: TextWatcher? = null
        private var repsWatcher: TextWatcher? = null

        fun bind(item: ExerciseUi) {
            // Remove old watchers so we don't stack them
            nameWatcher?.let { nameEdit.removeTextChangedListener(it) }
            setsWatcher?.let { setsEdit.removeTextChangedListener(it) }
            repsWatcher?.let { repsEdit.removeTextChangedListener(it) }

            // Set current values
            nameEdit.setText(item.name)
            setsEdit.setText(item.sets)
            repsEdit.setText(item.reps)

            // Create new watchers that update the backing list
            nameWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val pos = bindingAdapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        items[pos] = items[pos].copy(name = s?.toString().orEmpty())
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }

            setsWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val pos = bindingAdapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        items[pos] = items[pos].copy(sets = s?.toString().orEmpty())
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }

            repsWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val pos = bindingAdapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        items[pos] = items[pos].copy(reps = s?.toString().orEmpty())
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }

            nameEdit.addTextChangedListener(nameWatcher)
            setsEdit.addTextChangedListener(setsWatcher)
            repsEdit.addTextChangedListener(repsWatcher)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    // Called when you tap "Add exercise"
    fun add(item: ExerciseUi) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    // Called when loading from DB for an existing workout
    fun setItems(newItems: List<ExerciseUi>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    // Called in WorkoutActivity when saving
    fun getItems(): List<ExerciseUi> = items.toList()
}