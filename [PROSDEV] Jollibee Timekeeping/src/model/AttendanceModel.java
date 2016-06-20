package model;

public class AttendanceModel {
    private final int month;
    private final int day;
    private final int year;
    private final float timeIn;
    private final float timeOut;
    
    public AttendanceModel(int month, int day, int year, float timeIn, float timeOut){
        this.month = month;
        this.day = day;
        this.year = year;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public float getTimeIn() {
        return timeIn;
    }

    public float getTimeOut() {
        return timeOut;
    }
    
}
