package daniyal.android.basewithkotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import daniyal.android.basewithkotlin.data.local.dao.UserDao
import daniyal.android.basewithkotlin.data.local.entity.UserEntity

/**
 * Local Database class of Room
 */

@Database(entities = [UserEntity::class], version = 3)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}