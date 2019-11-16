package ni.devotion.mvvm.data.network.`interface`

import ni.devotion.mvvm.model.Department
import retrofit2.http.GET

interface DepartmentsInterface {
    @GET("getDepartments")
    suspend fun requestDepartments(): List<Department>
}