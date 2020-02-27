package week11.inheritancePlus;

import java.util.ArrayList;

public class SalariedPlusOnCallEmployee extends Employee{
    private ArrayList<WorkRecord> workRecords;
    private double[] schedule;

    public SalariedPlusOnCallEmployee(String first, String last, String ssn, double salary, double[] schedule){
        super(first, last, ssn);
    }

    @Override
    public double earnings() {
        return 0;
    }

    public void addWorkRecord(){

    }

    public boolean checkWorkRecords(){
        boolean retVal;

        return retVal;
    }

    public String scheduleToString(){
        String retVal;

        return retVal;
    }

    public String toString(){
        String retVal;

        return retVal;
    }


}


