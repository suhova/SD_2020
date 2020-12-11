package training.journal.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_workout.view.*
import kotlinx.android.synthetic.main.item_workout_element.view.title
import training.journal.db.entity.WorkoutEntity

class WorkoutViewHolder(
    itemView: View
) : BaseViewHolder<WorkoutEntity>(itemView) {

    private var startButton: ImageView = itemView.start
    private var deleteButton: ImageView = itemView.delete
    private var time: TextView = itemView.time
    private var title: TextView = itemView.title

    override fun bind(item: WorkoutEntity) {
//        time.text = item.time
        time.text = "8:00"
        title.text = item.name
    }

    fun setClickListeners(onStartClick: (View) -> Unit, onDeleteClick: (View) -> Unit) {
        startButton.setOnClickListener(onStartClick)
        deleteButton.setOnClickListener(onDeleteClick)
    }
}