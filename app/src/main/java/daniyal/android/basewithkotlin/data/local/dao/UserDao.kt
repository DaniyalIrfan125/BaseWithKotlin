package daniyal.android.basewithkotlin.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import daniyal.android.basewithkotlin.data.local.entity.UserEntity

/**
 * Dao class for Room Db
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM tbl_user")
    fun loadUsersList(): LiveData<List<UserEntity>>

    @Insert
    fun saveUser(user: UserEntity)
}