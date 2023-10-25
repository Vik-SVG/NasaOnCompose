package com.priesniakov.domain.usecase

import com.priesniakov.data.model.Astronomy
import com.priesniakov.data.model.core.Resource
import com.priesniakov.data.repository.ApodRepository
import javax.inject.Inject

class UpdateApodUseCase @Inject constructor(private val apodRepository: ApodRepository) {
    suspend operator fun invoke(): Resource<List<Astronomy>> =
        apodRepository.updateAstronomyDataFromRepository()
}