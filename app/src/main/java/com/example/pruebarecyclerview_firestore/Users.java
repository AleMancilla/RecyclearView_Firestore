package com.example.pruebarecyclerview_firestore;

public class Users {
    String title , nicknameuser;

    public Users ()
    {

    }

    public Users(String title, String nicknameuser) {
        this.title = title;
        this.nicknameuser = nicknameuser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNicknameuser() {
        return nicknameuser;
    }

    public void setNicknameuser(String nicknameuser) {
        this.nicknameuser = nicknameuser;
    }
}
