package de.smartwireless.smartaccess.presentation.mvi

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.SettingsBuilder
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax

fun <STATE : Any, SIDE_EFFECT : Any> CoroutineScope.container(
    initialState: STATE,
    buildSettings: SettingsBuilder.() -> Unit = {},
    onFailed: ((Throwable) -> Unit)? = {},
    onCreate: (suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit)? = null
): Container<STATE, SIDE_EFFECT> {
    val excHandler = onFailed?.let {
        CoroutineExceptionHandler { _, thr -> onFailed(thr) }
    }
    return container(
        initialState = initialState,
        buildSettings = { exceptionHandler = excHandler; buildSettings() },
        onCreate = onCreate
    )
}