package com.projectx.CurAndHomWorMon6.network

import androidx.lifecycle.MutableLiveData
import com.projectx.CurAndHomWorMon6.api.ApiService
import com.projectx.CurAndHomWorMon6.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository2 @Inject constructor(private val api: ApiService) {

    fun getCharacterById(id: Int): MutableLiveData<Character?> {
        val data = MutableLiveData<Character?>()

        api.fetchCharacterById(id).enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                } else {
                    data.postValue(null)
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                data.postValue(null)
            }
        })
        return data
    }
}
