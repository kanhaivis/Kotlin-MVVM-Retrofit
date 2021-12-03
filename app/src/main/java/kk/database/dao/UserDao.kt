package kk.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kk.database.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): User

    @Insert
    suspend fun insertAll(users: User)

    @Delete
    suspend fun delete(user: User)

}