package Classes;

import java.io.Serializable;

import java.util.ArrayList;

public class Directorate extends Unit implements Serializable {
    String direID;
    ArrayList<Department> listoFDepratments = new ArrayList<Department>();

    public Directorate(String _name, String _direInt) {
        super(_name);
        direID = _direInt;
    }

    public String getID() {
        return direID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(String _ID) {
        direID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

    public void removeDepartment(String _ID) {
        for (int i = 0; i >= listoFDepratments.size(); i++) {
            if (_ID == listoFDepratments.get(i).getID()) {
                listoFDepratments.remove(i);
            }
        }
    }

}
