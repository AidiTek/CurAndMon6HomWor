package com.projectx.CurAndHomWorMon6.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.CurAndHomWorMon6.Resource
import com.example.CurAndHomWorMon6.Resource.Success
import com.projectx.CurAndHomWorMon6.api.ApiService
import com.projectx.CurAndHomWorMon6.models.BaseResponse
import com.projectx.CurAndHomWorMon6.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: ApiService // Инъекция зависимости через Hilt или другой DI-фреймворк
) {

    // Функция для получения списка персонажей
    suspend fun fetchCharacters(): Resource<List<Character>> {
        return try {
            val response = api.fetchCharacter()
            // Извлекаем данные из тела ответа
            val characters = response.body()?.characters ?: emptyList()
            if (characters.isNotEmpty()) {
                Resource.Success(characters) // Исправлено на Resource.Success
            } else {
                Resource.Error("Список персонажей пуст")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Произошла ошибка во время загрузки данных")
        }
    }

    // Функция для получения персонажа по ID
    suspend fun getCharacterById(id: Int): Resource<Character?> {
        return try {
            val response = api.fetchCharacterById(id)
            // Извлекаем тело ответа
            val character = response.body() // Получаем объект персонажа
            Resource.Success(character) // Исправлено на Resource.Success
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Не удалось загрузить персонажа", null)
        }
    }
}


