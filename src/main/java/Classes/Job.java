package Classes;

import java.io.Serializable;

public class Job implements Serializable {
   String jobName;
   double baseSalary;

   public Job(String jobName, double baseSalary) {
      this.jobName = jobName;
      this.baseSalary = baseSalary;
   }

   public double calculateExpectedSalary(Applicant applicant) {
      double salary = 0;
      salary = baseSalary + (500 * applicant.getYearsOfExperience());

      return salary;
   }
}
