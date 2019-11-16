package ni.devotion.mvvm.di

import ni.devotion.mvvm.data.network.remoteDataSourceModule
import ni.devotion.mvvm.repo.DepartmentsRepository
import ni.devotion.mvvm.repo.DepartmentsRepositoryImpl
import ni.devotion.mvvm.viewModel.DepartmentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { DepartmentsViewModel(get()) }

    single<DepartmentsRepository> {
        DepartmentsRepositoryImpl(get())
    }
}

val allAppModules = listOf(appModule, remoteDataSourceModule)