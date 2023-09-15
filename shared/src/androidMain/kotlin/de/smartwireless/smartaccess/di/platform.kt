package de.smartwireless.smartaccess.di

import de.smartwireless.smartaccess.feature.AndroidFeatureViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val SharedAndroidModule = module {
    viewModelOf(::AndroidFeatureViewModel)
}