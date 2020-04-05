package com.deysofts.portalboy;

public class helper {

    public String name;
    public String attendance;
    public String figure;
    public helper() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public helper(String name, String attendance,String figure) {
        this.name = name;
        this.attendance = attendance;
        this.figure=figure;
    }

    public String getName()
    {
       return name;
    }
    public String getFigure()
    {
        return figure;
    }
    public void setFigure()
    {

    }
    public String getAttendance()
    {
       return attendance;
    }
    public void setName()
    {

    }
    public void setAttendance()
    {

    }

}
