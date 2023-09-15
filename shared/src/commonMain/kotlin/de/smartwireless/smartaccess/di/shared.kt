package de.smartwireless.smartaccess.di

import de.smartwireless.smartaccess.domain.state.StateUseCase
import de.smartwireless.smartaccess.feature.FeatureInteractor
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val SharedDomainModule: Module = module {
    factoryOf(::StateUseCase)
    factoryOf(::FeatureInteractor)
}