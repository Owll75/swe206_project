package Classes;

import java.io.Serializable;

import java.util.ArrayList;

public class division extends Unit implements Serializable {
    String divID;
    ArrayList<Directorate> listOfDirectorate = new ArrayList<Directorate>();

    public division(String _name, String _divID) {
        super(_name);
        divID = _divID;

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