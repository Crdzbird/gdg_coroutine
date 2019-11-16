package ni.devotion.mvvm.repo

import ni.devotion.mvvm.data.network.`interface`.DepartmentsInterface
import ni.devotion.mvvm.model.Department

interface DepartmentsRepository {
    suspend fun getDepartments(): List<Department>
}

class DepartmentsRepositoryImpl(private val departmentService: DepartmentsInterface):
    DepartmentsRepository {
    override suspend fun getDepartments(): List<Department> {
        return departmentService.requestDepartments()
    }
}