package com.projectx.CurAndHomWorMon6.api

import com.projectx.CurAndHomWorMon6.models.BaseResponse
import com.projectx.CurAndHomWorMon6.models.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    fun fetchCharacter(): Call<BaseResponse>

    @GET("character/{id}")
    fun fetchCharacterById(@Path("id") id: Int): Call<Character>
}
