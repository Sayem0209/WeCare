package com.example.we_care;

public class Ngomodel {
    String UserID;

    public Ngomodel(){

    }

    public Ngomodel(String userID) {
        UserID = userID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
