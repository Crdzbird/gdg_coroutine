package ni.abril.azb.megaboicotapp.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ni.devotion.mvvm.model.Department
import ni.devotion.mvvm.view_holder.DepartmentViewHolder

class DepartmentAdapter : ListAdapter<Department, DepartmentViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Department>() {
            override fun areItemsTheSame(oldItem: Department, newItem: Department) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Department, newItem: Department) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DepartmentViewHolder.create(parent)

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}