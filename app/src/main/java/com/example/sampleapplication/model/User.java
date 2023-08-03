package com.example.sampleapplication.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    public User(int Id , String username, String ufname, String ulname, String passsword) {
        this.Id=Id;
        this.username = username;
        this.ufname = ufname;
        this.ulname = ulname;
        this.passsword = passsword;
    }


    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int Id;

//    @ColumnInfo(name = "uId")
//    private int uId;
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "ufname")
    private String ufname;

    @ColumnInfo(name = "ulame")
    private String ulname;

    @ColumnInfo(name = "password")
    private String passsword;




//    public User(int Id, String username, String ufname, String ulname, String passsword) {
//        this.uId = Id;
//        this.username = username;
//        this.ufname = ufname;
//        this.ulname = ulname;
//        this.passsword = passsword;
//    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUfname() {
        return ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname;
    }

    public String getUlname() {
        return ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

//    public int getuId() {
//        return uId;
//    }
//
//    public void setuId(int uId) {
//        this.uId = uId;
//    }
}
