package com.projectx.CurAndHomWorMon6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.CurAndHomWorMon6.Resource
import com.projectx.CurAndHomWorMon6.models.Character
import com.projectx.CurAndHomWorMon6.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _characters = MutableLiveData<Resource<List<Character>>>()
    val characters: LiveData<Resource<List<Character>>> get() = _characters

    fun loadCharacters() {
        _characters.postValue(Resource.Loading())
        viewModelScope.launch {
            val result = repository.fetchCharacters()
            _characters.postValue(result)
        }
    }
}
