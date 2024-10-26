package com.projectx.CurAndHomWorMon6.network

import androidx.lifecycle.MutableLiveData
import com.example.CurAndHomWorMon6.Resource
import com.projectx.CurAndHomWorMon6.api.ApiService
import com.projectx.CurAndHomWorMon6.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository2 @Inject constructor(private val api: ApiService) {

    suspend fun getCharacterById(id: Int): Resource<Character?> {
        return try {
            val response = api.fetchCharacterById(id)
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.Error("Ошибка: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Не удалось загрузить персонажа")
        }
    }
}
