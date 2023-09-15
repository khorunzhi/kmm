package de.smartwireless.smartaccess.di

import de.smartwireless.smartaccess.feature.IosFeatureViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val SharedIosModule = module {
    factoryOf(::IosFeatureViewModel)
}