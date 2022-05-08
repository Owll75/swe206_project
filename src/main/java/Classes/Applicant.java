package Classes;

import java.util.ArrayList;

public class Applicant {
    int ID, yearsOfExperience;
    String position;
    jobBands jobBand;
    boolean passed;

    public Applicant(int ID, int yearsOfExperience, jobBands jobBand) {
        this.ID = ID;
        passed = true;
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

    public void setPosition(String position) {
        this.position = position;
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
