package com.projectx.CurAndHomWorMon6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.CurAndHomWorMon6.Resource
import com.projectx.CurAndHomWorMon6.models.Character
import com.projectx.CurAndHomWorMon6.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val characters: LiveData<Resource<List<Character>>> = repository.fetchCharacters()
}
