package Classes;

import java.io.Serializable;

public abstract class Unit implements Serializable {
    String name;

    public Unit(String _name) {

        name = _name;
    }
}
