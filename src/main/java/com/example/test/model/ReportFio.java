package com.example.test.model;

public class ReportFio {
    private String name;
    private String lastname;
    private String count;

    public ReportFio() {
    }

    public ReportFio(String name, String lastname, String count) {
        this.name = name;
        this.lastname = lastname;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
