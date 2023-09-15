package de.smartwireless.smartaccess.feature

import de.smartwireless.smartaccess.presentation.mvi.container
import de.smartwireless.smartaccess.presentation.viewmodel.DisposableViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

interface FeatureViewModel : ContainerHost<FeatureState, Nothing>, DisposableViewModel {

    val id: Int

    fun onClick()
}

internal class RealFeatureViewModel(
    override val id: Int,
    private val scope: CoroutineScope = MainScope(),
    private val interactor: FeatureInteractor,
) : FeatureViewModel {

    override val container: Container<FeatureState, Nothing> =
        scope.container(initialState = FeatureState(start = id))

    override fun onDispose() = scope.cancel()

    override fun onClick() {
        intent {
            interactor.updateState(id)
            reduce {
                state.copy(counter = state.counter.inc())
            }
        }
    }
}