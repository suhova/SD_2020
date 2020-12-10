package training.journal.viewholders

import android.view.View
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.item_exercise_element.view.*
import training.journal.items.ExerciseItem

class ExerciseElementViewHolder(
    itemView: View
) : BaseViewHolder<ExerciseItem>(itemView) {

    private var title: EditText = itemView.title
    private var value: EditText = itemView.value
    private var units: Spinner = itemView.units
    private var inputType: Spinner = itemView.input_type

    override fun bind(item: ExerciseItem) {
        title.setText(item.title)
        value.setText(item.value.toString())
        units.setSelection(item.unitIndex)
        inputType.setSelection(item.inputTypeIndex)
    }
}