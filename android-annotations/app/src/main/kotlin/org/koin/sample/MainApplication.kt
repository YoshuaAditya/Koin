package org.koin.sample

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.sample.data.DefaultData.DEFAULT_USERS
import org.koin.sample.data.UserRepository
// generated
import org.koin.ksp.generated.*
import org.koin.sample.di.AppModule

/**
 * Main Application
 */
class MainApplication : Application() {

    private val userRepository : UserRepository by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(AppModule().module)
        }

        userRepository.addUsers(DEFAULT_USERS)
    }
}
