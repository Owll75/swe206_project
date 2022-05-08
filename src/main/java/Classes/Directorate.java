package Classes;

import java.util.ArrayList;

public class Directorate extends Unit {
    int direID;
    ArrayList<Department> listoFDepratments = new ArrayList<Department>();

    public Directorate(String _name, int _direInt) {
        super(_name);
        direID = _direInt;
    }

    public int getID() {
        return direID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(int _ID) {
        direID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

}
