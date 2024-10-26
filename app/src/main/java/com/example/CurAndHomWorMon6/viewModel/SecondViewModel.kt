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
class SecondViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _character = MutableLiveData<Resource<Character?>>()
    val character: LiveData<Resource<Character?>> get() = _character

    fun loadCharacterById(id: Int) {
        _character.postValue(Resource.Loading())
        viewModelScope.launch {
            val result = repository.getCharacterById(id)
            _character.postValue(result)
        }
    }
}
