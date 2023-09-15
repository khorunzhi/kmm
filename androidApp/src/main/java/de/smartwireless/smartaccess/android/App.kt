package de.smartwireless.smartaccess.android

import android.app.Application
import de.smartwireless.smartaccess.di.Di

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Di.start()
    }
}
