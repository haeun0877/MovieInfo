package com.example.boxoffice.base

import android.app.Application
import com.example.boxoffice.remote.local.PreferenceUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        PreferenceUtil().setPref(this)
    }
}