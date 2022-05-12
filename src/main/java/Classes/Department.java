package Classes;

public class Department extends Unit {
    String depID;

    public Department(String _name, String _depId) {
        super(_name);
        depID = _depId;

    }

    public String getID() {
        return depID;
    }

    public String getName() {
        return super.name;
    }

    public void setID(String _ID) {
        depID = _ID;

    }

    public void setName(String _Name) {
        super.name = _Name;
    }

}
