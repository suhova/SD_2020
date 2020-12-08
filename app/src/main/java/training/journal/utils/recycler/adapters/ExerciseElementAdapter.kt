package training.journal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_element.view.*
import training.journal.R
import training.journal.utils.recycler.elements.ExerciseElement

class ExerciseElementAdapter(private val elements: List<ExerciseElement>)
    : RecyclerView.Adapter<ExerciseElementAdapter.ExerciseElementHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseElementHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise_element, parent, false)
        return ExerciseElementHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ExerciseElementHolder, position: Int) {
        holder.bind(elements[position])
    }

    class ExerciseElementHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var title: EditText = itemView.title
        private var value: EditText = itemView.value
        private var units: Spinner = itemView.units
        private var inputType: Spinner = itemView.input_type

        fun bind(element: ExerciseElement) {
            title.setText(element.title)
            value.setText(element.value.toString())
            units.setSelection(element.unitIndex)
            inputType.setSelection(element.inputTypeIndex)
        }
    }
}
