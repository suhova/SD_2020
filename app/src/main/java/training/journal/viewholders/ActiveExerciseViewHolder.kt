package training.journal.viewholders

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.item_active_exercise_element.view.*
import training.journal.db.model.ParameterModel
import training.journal.items.Parameter

class ActiveExerciseViewHolder(
        itemView: View
) : BaseViewHolder<ParameterModel>(itemView) {

    private var name: TextView = itemView.parameter_name
    private var value: EditText = itemView.parameter_value
    private var unit: TextView = itemView.parameter_unit

    override fun bind(item: ParameterModel) {
        name.text = item.parameter.name

        val measureUnit = item.measureUnitChoices[item.parameter.measureUnitId.toInt() - 1]
        unit.text = measureUnit.acronym

        val parameterType = item.parameterTypeChoices[item.parameter.parameterTypeId.toInt() - 1]
        value.isEnabled = !parameterType.onCreateFilling
        value.setText(item.parameter.value.toString())

        if (value.isEnabled) {
            value.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s != null && s.isNotEmpty()) {
                        val newValue: Float? = s.toString().toFloatOrNull()
                        if (newValue != null) {
                            item.parameter.value = newValue
                        }
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
    }
}