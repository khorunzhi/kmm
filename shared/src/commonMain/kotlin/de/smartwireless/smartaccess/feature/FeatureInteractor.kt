package de.smartwireless.smartaccess.feature

import de.smartwireless.smartaccess.domain.state.StateUseCase

class FeatureInteractor(private val stateUseCase: StateUseCase) {
    suspend fun updateState(id: Int) = stateUseCase.invoke(id)
}