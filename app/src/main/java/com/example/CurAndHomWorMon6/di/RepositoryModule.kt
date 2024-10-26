package com.example.CurAndHomWorMon6.di

import com.projectx.CurAndHomWorMon6.network.Repository
import com.projectx.CurAndHomWorMon6.network.Repository2
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
    single { Repository2(get()) }
}