package de.smartwireless.smartaccess.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

object Di {
    fun start() = startKoin {
        loadKoinModules(
            listOf(SharedDomainModule, SharedAndroidModule)
        )
    }
}