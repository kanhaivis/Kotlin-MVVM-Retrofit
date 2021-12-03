package kk.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kk.database.entity.User
import kk.model.ResultData

@Dao
interface ResultDao {
//
    @Query("SELECT * FROM user_datas")
    suspend fun getAll(): List<ResultData>

    @Insert
    suspend fun insertAll(kkData: List<ResultData>)

    @Delete
    suspend fun delete(kkData: ResultData)

}