package ni.devotion.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ni.devotion.mvvm.R
import ni.devotion.mvvm.model.Department
import ni.devotion.mvvm.repo.DepartmentsRepository

class DepartmentsViewModel (private val departmentRepository: DepartmentsRepository): ViewModel() {
    private val _uiState = MutableLiveData<BusinessDataState>()
    val uiState: LiveData<BusinessDataState> get() = _uiState

    init {
        retrieveBusiness()
    }

    fun retrieveBusiness(){
        viewModelScope.launch {
                runCatching {
                    emitUiState(showProgress = true)
                    departmentRepository.getDepartments()
                }.onSuccess {
                    emitUiState(department = Event(it))
                }.onFailure {
                    emitUiState(error = Event(R.string.internet_failure_error))
                }
        }
    }

    private fun emitUiState(showProgress: Boolean = false, department: Event<List<Department>>? = null, error: Event<Int>? = null){
        val dataState = BusinessDataState(showProgress, department, error)
        _uiState.value = dataState
    }

    data class BusinessDataState(val showProgress: Boolean, val department: Event<List<Department>>?, val error: Event<Int>?)
}