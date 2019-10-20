package daniyal.android.basewithkotlin.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
class UserEntity(
        @ColumnInfo(name = "username") val name: String = "", @ColumnInfo(name = "userage")
        val userage: String? = null){

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
}

