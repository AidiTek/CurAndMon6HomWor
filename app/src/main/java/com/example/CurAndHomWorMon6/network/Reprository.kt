package com.projectx.CurAndHomWorMon6.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.CurAndHomWorMon6.Resource
import com.projectx.CurAndHomWorMon6.api.ApiService
import com.projectx.CurAndHomWorMon6.models.BaseResponse
import com.projectx.CurAndHomWorMon6.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {

    fun fetchCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())

        api.fetchCharacter().enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        data.postValue(Resource.Success(body.characters))
                    } ?: data.postValue(Resource.Error("Данные не найдены"))
                } else {
                    data.postValue(Resource.Error("Ошибка при загрузке данных"))
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                data.postValue(Resource.Error("Ошибка: ${t.message}"))
            }
        })
        return data
    }
}
