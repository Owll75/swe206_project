package Classes;

public class Department extends Unit {
    int depID;

    public Department(String _name, int _depId) {
        super(_name);
        depID = _depId;

    }

    public int getID() {
        return depID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(int _ID) {
        depID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

}
