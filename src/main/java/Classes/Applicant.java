package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Applicant implements Serializable{
    int ID, yearsOfExperience;
    String position;
    jobBands jobBand;
    boolean passed;
    String report = "";

    public Applicant(int ID, int yearsOfExperience, jobBands jobBand) {
        this.ID = ID;
        passed = false;
        this.yearsOfExperience = yearsOfExperience;
        position = "";
        this.jobBand = jobBand;

    }

    public int getID() {
        return ID;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getPosition() {
        return position;
    }

    public boolean passedApplication() {
        return passed;
    }

    public void setPassed(boolean passed){
        this.passed = passed;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setReport(String report){
        this.report = report;
    }

    public String getBandName(){
        return jobBand.getBandName();
    }

    public String getReport(){
        return report;
    }

    public ArrayList<Double> createJobOffer() {
        // all calculations from excel

        double salary = jobBand.totalSalary();

        if (position.equals("Divison Level"))
            salary = salary + 1000;

        if (position.equals("Directorate Level"))
            salary = salary + 500;

        double expectedBasicSalary = salary + (500 * yearsOfExperience);
        double minBasicSalary = salary + (500 * (yearsOfExperience - 2));
        double housingBenefit = minBasicSalary * 0.25;
        double transportationBenefit = minBasicSalary * 0.1;
        minBasicSalary = minBasicSalary + housingBenefit + transportationBenefit;

        double maxBasicSalary = salary + (500 * (yearsOfExperience + 2));
        housingBenefit = maxBasicSalary * 0.25;
        transportationBenefit = maxBasicSalary * 0.1;
        maxBasicSalary = minBasicSalary + housingBenefit + transportationBenefit;

        ArrayList<Double> salaries = new ArrayList<Double>();
        salaries.add(expectedBasicSalary);
        salaries.add(minBasicSalary);
        salaries.add(maxBasicSalary);
        return salaries;

    }
}
