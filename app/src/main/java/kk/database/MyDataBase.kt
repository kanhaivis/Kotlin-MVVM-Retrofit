package kk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kk.database.dao.ResultDao
import kk.database.dao.UserDao
import kk.database.entity.User
import kk.model.ResultData

@Database(entities = [User::class, ResultData::class], version = 1)
@TypeConverters(Converters::class)
abstract class MyDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun resutDataDao() : ResultDao

    companion object {
        @Volatile
        private var instance: MyDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MyDataBase::class.java, "kkk.db"
        ).build()
    }
}