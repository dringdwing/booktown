package com.vector.entity;

public class User {
    private String USER_ID;
    private String USER_NAME;
    private String USER_PASSWORD;
    private String USER_BIRTHDAY;
    private String USER_IDENITY_CODE;
    private String USER_EMAIL;
    private String USER_MOBLE;
    private String USER_ADDRESS;
    private int USER_STATUS;
    private String USER_SEX;

    public User() {
    }

    public User(String USER_ID, String USER_NAME, String USER_PASSWORD, String USER_BIRTHDAY, String USER_IDENITY_CODE, String USER_EMAIL, String USER_MOBLE, String USER_ADDRESS, int USER_STATUS, String USER_SEX) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASSWORD = USER_PASSWORD;
        this.USER_BIRTHDAY = USER_BIRTHDAY;
        this.USER_IDENITY_CODE = USER_IDENITY_CODE;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_MOBLE = USER_MOBLE;
        this.USER_ADDRESS = USER_ADDRESS;
        this.USER_STATUS = USER_STATUS;
        this.USER_SEX = USER_SEX;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_BIRTHDAY() {
        return USER_BIRTHDAY;
    }

    public void setUSER_BIRTHDAY(String USER_BIRTHDAY) {
        this.USER_BIRTHDAY = USER_BIRTHDAY;
    }

    public String getUSER_IDENITY_CODE() {
        return USER_IDENITY_CODE;
    }

    public void setUSER_IDENITY_CODE(String USER_IDENITY_CODE) {
        this.USER_IDENITY_CODE = USER_IDENITY_CODE;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public String getUSER_MOBLE() {
        return USER_MOBLE;
    }

    public void setUSER_MOBLE(String USER_MOBLE) {
        this.USER_MOBLE = USER_MOBLE;
    }

    public String getUSER_ADDRESS() {
        return USER_ADDRESS;
    }

    public void setUSER_ADDRESS(String USER_ADDRESS) {
        this.USER_ADDRESS = USER_ADDRESS;
    }

    public int getUSER_STATUS() {
        return USER_STATUS;
    }

    public void setUSER_STATUS(int USER_STATUS) {
        this.USER_STATUS = USER_STATUS;
    }

    public String getUSER_SEX() {
        return USER_SEX;
    }

    public void setUSER_SEX(String USER_SEX) {
        this.USER_SEX = USER_SEX;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_ID='" + USER_ID + '\'' +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PASSWORD='" + USER_PASSWORD + '\'' +
                ", USER_BIRTHDAY='" + USER_BIRTHDAY + '\'' +
                ", USER_IDENITY_CODE='" + USER_IDENITY_CODE + '\'' +
                ", USER_EMAIL='" + USER_EMAIL + '\'' +
                ", USER_MOBLE='" + USER_MOBLE + '\'' +
                ", USER_ADDRESS='" + USER_ADDRESS + '\'' +
                ", USER_STATUS=" + USER_STATUS +
                ", USER_SEX='" + USER_SEX + '\'' +
                '}';
    }
}

