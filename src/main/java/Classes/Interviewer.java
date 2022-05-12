package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Interviewer implements Serializable {
	ArrayList<Interview>listOfJobs;
	String name;

	public Interviewer(String name){
		this.name = name;
	}
	public String getName(){return name;}

	public void setResult(int ID, String result1) {
		for (int i = 0; i < listOfJobs.size(); i++) {
			if(listOfJobs.get(i).getID() == ID) {
				listOfJobs.get(i).setResult(result1);
			}
		}
	}

	public ArrayList<Interview> getlistOfJobs(){
		return listOfJobs;
	}
}
