package Classes;

import java.util.ArrayList;

public class division extends Unit {
    int divID;
    ArrayList<Directorate> listOfDirectorate = new ArrayList<Directorate>();

    public division(String _name, int _divID) {
        super(_name);
        divID = _divID;

    }

    public int getID() {
        return divID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(int _ID) {
        divID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

    public void removeDirectorate(int _ID) {
        for (int i = 0; i >= listOfDirectorate.size(); i++) {
            if (_ID == listOfDirectorate.get(i).getID()) {
                listOfDirectorate.remove(i);
            }
        }
    }

}