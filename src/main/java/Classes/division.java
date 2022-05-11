package Classes;

import java.util.ArrayList;

public class division extends Unit {
    String divID;
    ArrayList<Directorate> listOfDirectorate = new ArrayList<Directorate>();

    public division(String _name, String _ID) {
        super(_name);
        divID = _ID;

    }

    public String getID() {
        return divID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(String _ID) {
        divID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

    public void removeDirectorate(String _ID) {
        for (int i = 0; i >= listOfDirectorate.size(); i++) {
            if (_ID == listOfDirectorate.get(i).getID()) {
                listOfDirectorate.remove(i);
            }
        }
    }

}