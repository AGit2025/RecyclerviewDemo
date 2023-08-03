package com.example.sampleapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class Userktln {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uId")
    private var uId = 0

    @ColumnInfo(name = "username")
    private var username: String? = null

    @ColumnInfo(name = "ufname")
    private var ufname: String? = null

    @ColumnInfo(name = "ulame")
    private var ulname: String? = null

    @ColumnInfo(name = "password")
    private var passsword: String? = null

    fun User(uId: Int, username: String?, ufname: String?, ulname: String?, passsword: String?) {
        this.uId = uId
        this.username = username
        this.ufname = ufname
        this.ulname = ulname
        this.passsword = passsword
    }

    fun getuId(): Int {
        return uId
    }

    fun setuId(uId: Int) {
        this.uId = uId
    }

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getUfname(): String? {
        return ufname
    }

    fun setUfname(ufname: String?) {
        this.ufname = ufname
    }

    fun getUlname(): String? {
        return ulname
    }

    fun setUlname(ulname: String?) {
        this.ulname = ulname
    }

    fun getPasssword(): String? {
        return passsword
    }

    fun setPasssword(passsword: String?) {
        this.passsword = passsword
    }
}