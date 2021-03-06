package com.example.medcords

import android.app.Application
import com.example.medcords.network.Api
import com.example.medcords.repository.MainRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MainApplication : Application(),KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))
      //  bind() from singleton { Api(instance()) }
        bind() from singleton { MainRepository(instance()) }

    }
}