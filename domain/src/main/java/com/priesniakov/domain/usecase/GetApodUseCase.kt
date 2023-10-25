package com.priesniakov.domain.usecase

import com.priesniakov.data.model.Astronomy
import com.priesniakov.data.model.core.Resource
import com.priesniakov.data.repository.ApodRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class GetApodUseCase @Inject constructor(private val apodRepository: ApodRepository) {
    suspend operator fun invoke(): Resource<List<Astronomy>> =
        apodRepository.getAstronomyDataFromRepository()
}
