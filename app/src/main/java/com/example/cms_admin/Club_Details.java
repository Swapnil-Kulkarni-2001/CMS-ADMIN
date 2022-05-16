package com.example.cms_admin;

public class Club_Details
{
    public String name;
    public String type;
    public int logo;

    public Club_Details(String name, String type, int logo) {
        this.name = name;
        this.type = type;
        this.logo = logo;
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
