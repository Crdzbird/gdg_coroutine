package ni.devotion.mvvm.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.department_content.*
import ni.devotion.mvvm.R
import ni.devotion.mvvm.model.Department

class DepartmentViewHolder constructor(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(department: Department) {
        departmentName.text = department.department
    }

    companion object {
        fun create(parent: ViewGroup): DepartmentViewHolder {
            return DepartmentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.department_card, parent, false))
        }
    }
}