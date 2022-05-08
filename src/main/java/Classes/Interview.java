package Classes;

public class Interview {
   int ID;
   String date;
   Applicant applicant;
   Interviewer interviewer;
   public Interview(int ID, String date, Applicant applicant, Interviewer interviewer){
      this.ID = ID;
      this.date = date;
      this.applicant = applicant;
      this.interviewer = interviewer;
   }

   public Applicant getApplicant() {
      return applicant;
   }
}
