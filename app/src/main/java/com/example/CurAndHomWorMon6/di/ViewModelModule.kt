package com.example.CurAndHomWorMon6.di

import com.projectx.CurAndHomWorMon6.viewModel.FragmentViewModel
import com.projectx.CurAndHomWorMon6.viewModel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FragmentViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}