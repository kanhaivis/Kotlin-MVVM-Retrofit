package kk.model

import androidx.room.Entity


data class UserResponse(
    val info: Info,
    val results: List<ResultData>
)