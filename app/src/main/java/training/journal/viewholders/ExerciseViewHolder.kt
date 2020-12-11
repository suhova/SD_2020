package training.journal.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_workout_element.view.*
import training.journal.db.entity.ExerciseEntity

class ExerciseViewHolder(
    itemView: View
) : BaseViewHolder<ExerciseEntity>(itemView) {

    private var title: TextView = itemView.title
    private var description: TextView = itemView.description
    private var delete: ImageView = itemView.delete_parameter_button

    override fun bind(item: ExerciseEntity) {
        title.text = item.name
        description.text = item.description
    }

    fun setClickListener(onDeleteClick: (View) -> Unit) {
        delete.setOnClickListener(onDeleteClick)
    }
}