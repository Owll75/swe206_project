package Classes;
public class Employee{
   String username;
   String password;
   String stats;
   public Employee(String username,String password,String stats){
      this.username=username;
      this.password=password;
      this.stats=stats;
   }
   public void setStats(String stats){
      this.stats=stats;
   }
}