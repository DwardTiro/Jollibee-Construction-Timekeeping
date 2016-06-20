
package model;

import java.util.Calendar;

public class CalendarModel {
    
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
}
