package com.projectx.CurAndHomWorMon6.models



import com.google.gson.annotations.SerializedName


data class BaseResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)