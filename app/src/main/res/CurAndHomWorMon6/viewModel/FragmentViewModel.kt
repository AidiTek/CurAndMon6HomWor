package com.projectx.CurAndHomWorMon6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.projectx.CurAndHomWorMon6.models.Character
import com.projectx.CurAndHomWorMon6.network.Reprository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor (
    private val reprository: Reprository
) :ViewModel() {

    val characters: LiveData<List<Character>> = reprository.fetchCharacters()
}