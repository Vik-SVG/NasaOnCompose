package com.priesniakov.domain.usecase

import com.priesniakov.data.model.Astronomy
import com.priesniakov.core.network.Resource
import com.priesniakov.core.usecase.FlowableUseCase
import com.priesniakov.core.usecase.FlowableUseCaseImpl
import com.priesniakov.data.repository.ApodRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetApodUseCase @Inject constructor(private val apodRepository: ApodRepository) :
    FlowableUseCase by FlowableUseCaseImpl() {
    operator fun invoke(): Flow<Resource<List<Astronomy>>> = invoke {
        apodRepository.getAstronomyDataFromRepository()
    }
}