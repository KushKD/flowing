package com.mis.education.Education.MIS.modules.user.modal;

import java.io.Serializable;

public class LoggedInUserLocationSession implements Serializable {


    private Long userID;



    public LoggedInUserLocationSession(Long userID) {

        this.userID = userID;
    }



    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }



    @Override
    public String toString() {
        return "LoggedInUserLocationSession{" +
                ", userID=" + userID +
                '}';
    }
}
