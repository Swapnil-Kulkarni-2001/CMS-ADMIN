package com.example.cms_admin;

public class Club_Details
{
    public String name;
    public String full_name;
    public String date;
    public String type;
    public int logo;

    public Club_Details(String name, String type, int logo) {
        this.name = name;
        this.type = type;
        this.logo = logo;
    }

    public Club_Details(String name, String full_name, String date, String type, int logo) {
        this.name = name;
        this.full_name = full_name;
        this.date = date;
        this.type = type;
        this.logo = logo;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
