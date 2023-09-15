package de.smartwireless.smartaccess.di

import de.smartwireless.smartaccess.feature.IosFeatureViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

object Di: KoinComponent {
    init {
        startKoin {
            loadKoinModules(
                listOf(SharedDomainModule, SharedIosModule)
            )
        }
    }

    fun featureViewModel(id: Int): IosFeatureViewModel = get { parametersOf(id) }
}