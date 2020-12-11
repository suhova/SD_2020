package training.journal.utils.recycler.adapters

import androidx.annotation.LayoutRes
import training.journal.db.model.ParameterModel
import training.journal.items.ItemsList
import training.journal.viewholders.BaseViewHolder
import training.journal.viewholders.ExerciseElementViewHolder
import kotlin.reflect.KClass

class ParameterListAdapter(
    holderType: KClass<out ExerciseElementViewHolder>,
    @LayoutRes layoutId: Int,
    dataSource: ItemsList<ParameterModel>,
    onClick: (ParameterModel) -> Unit = {},
    private val onDeleteParameterClick: (ParameterModel) -> Unit = {}
) : BaseListAdapter<ParameterModel>(holderType, layoutId, dataSource, onClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ParameterModel>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = data[position]
        (holder as ExerciseElementViewHolder).setClickListener { onDeleteParameterClick.invoke(item) }
    }
}
