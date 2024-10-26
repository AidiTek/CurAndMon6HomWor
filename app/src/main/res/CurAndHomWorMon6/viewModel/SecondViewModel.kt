package com.projectx.CurAndHomWorMon6.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projectx.CurAndHomWorMon6.models.Character
import com.projectx.CurAndHomWorMon6.network.Reprository2
import javax.inject.Inject

class SecondViewModel @Inject constructor(private val repository2: Reprository2) : ViewModel() {

    fun getCharacterById(id: Int): MutableLiveData<Character?> {
        return repository2.getCharacterById(id)
    }
}