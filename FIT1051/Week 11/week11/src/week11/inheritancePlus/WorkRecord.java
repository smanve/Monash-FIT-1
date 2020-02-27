package week11.inheritancePlus;

public class WorkRecord {
    private double hours;
    private int dayCode;
    private double agreedHourlyRate;

    public WorkRecord(double workHours, double hourlyRate, int day){
        setHours(workHours);
        setAgreedHourlyRate(hourlyRate);
        setDayCode(day);
    }

    public WorkRecord(){

    }

    public double getHours(){
        return hours;
    }

    public double getAgreedHourlyRate(){
        return agreedHourlyRate;
    }

    public int getDayCode(){
        return dayCode;
    }

    private void setDayCode(int day){
        if((dayCode >= 1) && (dayCode <=7)){
            dayCode = day;
        }
    }

    private void setHours(double workHours){
        if(workHours >= 0.0){
            hours = workHours;
        }
    }

    private void setAgreedHourlyRate(double hourlyRate){
        if(hourlyRate > 0.0){
            agreedHourlyRate = hourlyRate;
        }
    }

    public String toString(){
        String retVal = "";

        retVal += "Work Hours: " + hours + "\nDay: " + dayCode + "\nHourly Rate: " + agreedHourlyRate;

        return retVal;
    }
}
