package com.example.iconnect;


/************************************************************
 * Class: Connection
 * Function: Collect the information about each person or group
 * while providing methods that give access to each person or groups
 * information
 ************************************************************/
public class Connection {
    private String name;
    private String id;
    private String subtitle;
    private String frequency;
    private String note;
    private String setCount;

    //Making some changes

    //Non-default constructor
    public Connection(String name) {
       this.name = name;
       id = "";
       subtitle = "";
       frequency = "0";
       note = "";
       setCount = "0";
    }

    //Non-default constructor
    public Connection(String name, String id, String subtitle, String frequency, String note) {
        this.name = name;
        this.id = id;
        this.subtitle = subtitle;
        this.frequency = frequency;
        this.note = note;
        this.setCount = "0";
    }

    //Non-default constructor
    public Connection(String name, String id, String subtitle, String frequency, String note, String setCount) {
        this.name = name;
        this.id = id;
        this.subtitle = subtitle;
        this.frequency = frequency;
        this.note = note;
        this.setCount = setCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSetCount() {
        return setCount;
    }

    public void setSetCount(String setCount) {
        this.setCount = setCount;
    }
}
