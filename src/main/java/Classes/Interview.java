package Classes;


public class Interview {
   int ID;
   String date;
   Applicant applicant;
   Interviewer interviewer;
   String result;
   public Interview(int ID, String date, Applicant applicant, Interviewer interviewer){
      this.ID = ID;
      this.date = date;
      this.applicant = applicant;
      this.interviewer = interviewer;
      result = "TBA";
   }

   public Applicant getApplicant() {
      return applicant;
   }

   public int getID() {
      return ID;
   }

   public String getDate() {
      return date;
   }

   public Interviewer getInterviewer() {
      return interviewer;
   }

   public String getResult() {
      return result;
   }
}
