package training.journal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_workout_element.view.*
import training.journal.R
import training.journal.utils.recycler.elements.WorkoutElement

class WorkoutElementAdapter(private var elements: List<WorkoutElement>, private val onClick: ((v: View?) -> Unit)?)
    : RecyclerView.Adapter<WorkoutElementAdapter.WorkoutElementHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutElementHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_element, parent, false)
        view.setOnClickListener(onClick)
        return WorkoutElementHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: WorkoutElementHolder, position: Int) {
        holder.bind(elements[position])
    }

    class WorkoutElementHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var icon: ImageView = itemView.icon
        private var title: TextView = itemView.title
        private var description: TextView = itemView.description

        fun bind(element: WorkoutElement) {
            icon.setImageResource(element.iconId)
            title.text = element.title
            description.text = element.description
        }
    }
}
