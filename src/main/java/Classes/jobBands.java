package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class jobBands implements Serializable {
   String bandName;
   int bandID;
   ArrayList<Job> listOfJobs;

   public jobBands(String bandName, int bandID, ArrayList<Job> listOfJobs) {
      this.bandName = bandName;
      this.bandID = bandID;
      this.listOfJobs = listOfJobs;
   }
   public String getBandName(){
      return bandName;
   }

   public int getBandID(){
      return bandID;
   }

   public void addBand(String bandName, int bandID, ArrayList<Job> listOfJobs) {
      new jobBands(bandName, bandID, listOfJobs);
   }

   public void deleteBand() {
      bandName = null;
      bandID = 0;
      listOfJobs.clear();
   }

   public void modifyBand(String bandName, int bandID) {
      if (!bandName.equals(""))
         this.bandName = bandName;
      if (!(bandID == 0))
         this.bandID = bandID;

   }

   public void assignBand(Job Job) {
      this.listOfJobs.add(Job);
   }

   public double totalSalary() {
      double salary = 0;
      if (listOfJobs.contains("Program Manager"))
         salary = salary + 14000;

      if (listOfJobs.contains("Product Manager"))
         salary = salary + 12000;

      if (listOfJobs.contains("Senior Engineer"))
         salary = salary + 14000;

      if (listOfJobs.contains("Lead Engineer"))
         salary = salary + 10000;

      if (listOfJobs.contains("Engineer"))
         salary = salary + 8000;

      return salary;
   }

}
