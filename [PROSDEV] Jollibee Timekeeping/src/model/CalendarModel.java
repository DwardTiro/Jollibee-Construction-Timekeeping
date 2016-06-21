
package model;

import java.util.Calendar;

public class CalendarModel {
    
    public static final int NJANUARY = 1;
    public static final int NFEBRUARY = 2;
    public static final int NMARCH = 3;
    public static final int NAPRIL = 4;
    public static final int NMAY = 5;
    public static final int NJUNE = 6;
    public static final int NJULY = 7;
    public static final int NAUGUST = 8;
    public static final int NSEPTEMBER = 9;
    public static final int NOCTOBER = 10;
    public static final int NNOVEMBER = 11;
    public static final int NDECEMBER = 12;
    
    public static final String SJANUARY = "January";
    public static final String SFEBRUARY = "February";
    public static final String SMARCH = "March";
    public static final String SAPRIL = "April";
    public static final String SMAY = "May";
    public static final String SJUNE = "June";
    public static final String SJULY = "July";
    public static final String SAUGUST = "August";
    public static final String SSEPTEMBER = "September";
    public static final String SOCTOBER = "October";
    public static final String SNOVEMBER = "November";
    public static final String SDECEMBER = "December";
    
    private static final int MIN_MONTHS = 1;
    private static final int MAX_MONTHS = 12;
    
    private static final CalendarModel calendarModel = new CalendarModel();
    
    private int month;
    private int firstDay;
    private int maxDays;
    private int year;
    
    private CalendarModel(){
        Calendar c = Calendar.getInstance();    // this takes current date

        c.set(Calendar.DAY_OF_MONTH, 1);        // gets the first day of the month
        
        String[] preset = String.valueOf(c.getTime()).split(" ");
        firstDay = getEquivalentDay(preset[0]);
        month = getEquivalentMonth(preset[1]);
        year = Integer.parseInt(preset[5]);
        maxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
    }
    
    public static CalendarModel getInstance(){
        return calendarModel;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getFirstDay(){
        return firstDay;
    }
    
    public int getMaxDays(){
        return maxDays;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public void setFirstDay(int firstDay){
        this.firstDay = firstDay;
    }
    
    public void setMaxDays(int maxDays){
        this.maxDays = maxDays;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    private int getEquivalentMonth(String month){
        int tempMonth = 0;
        switch(month){
            case "Jan" : tempMonth = 1;     break;
            case "Feb" : tempMonth = 2;     break;
            case "Mar" : tempMonth = 3;     break;
            case "Apr" : tempMonth = 4;     break;
            case "May" : tempMonth = 5;     break;
            case "Jun" : tempMonth = 6;     break;
            case "Jul" : tempMonth = 7;     break;
            case "Aug" : tempMonth = 8;     break;
            case "Sep" : tempMonth = 9;     break;
            case "Oct" : tempMonth = 10;    break;
            case "Nov" : tempMonth = 11;    break;
            case "Dec" : tempMonth = 12;    break;
        }
        return tempMonth;
    }
    
    private int getEquivalentDay(String day){
        int tempDay = 0;
        switch(day){
            case "Sun" : tempDay = 0;   break;
            case "Mon" : tempDay = 1;   break;
            case "Tue" : tempDay = 2;   break;
            case "Wed" : tempDay = 3;   break;
            case "Thu" : tempDay = 4;   break;
            case "Fri" : tempDay = 5;   break;
            case "Sat" : tempDay = 6;   break;
        }
        return tempDay;
    }
    
    public void moveToNextMonth(){
        month++;
        if(month > MAX_MONTHS){
            month = 1;
            year++;
        }
        refreshCalendar();
    }
    
    public void moveToPreviousMonth(){
        month--;
        if(month < MIN_MONTHS){
            month = 12;
            year--;
        }
        refreshCalendar();
    }
    
    private void refreshCalendar(){
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        String[] preset = String.valueOf(c.getTime()).split(" ");
        
        setFirstDay(getEquivalentDay(preset[0]));
        setMaxDays(c.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}
