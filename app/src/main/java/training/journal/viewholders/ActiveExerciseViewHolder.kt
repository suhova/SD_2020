package training.journal.viewholders

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_active_exercise_element.view.*
import training.journal.items.ExerciseItem

class ActiveExerciseViewHolder(
    itemView: View
) : BaseViewHolder<ExerciseItem>(itemView) {

    private var title: TextView = itemView.parameter
    private var goal: TextView = itemView.parameter_goal

    override fun bind(item: ExerciseItem) {
        title.text = item.title
        goal.text = item.value.toString()
    }
}