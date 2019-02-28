package com.kazimad.movieparser.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(var mApplication: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mApplication
    }

}