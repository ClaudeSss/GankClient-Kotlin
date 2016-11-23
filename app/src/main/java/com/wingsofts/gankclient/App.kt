package com.wingsofts.gankclient

import android.app.Application
import com.wingsofts.gankclient.di.component.DaggerApiComponent
import com.wingsofts.gankclient.di.module.ApiModule
import com.wingsofts.gankclient.di.module.AppModule
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by wing on 16-11-22.
 */
class App :Application(){
   @Inject lateinit var mRetrofit :Retrofit
    override fun onCreate() {
        super.onCreate()

        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }
}