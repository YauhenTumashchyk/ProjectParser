package com.tumashchick.pp.container;

import java.util.ArrayList;

public abstract class ObjContainer {

    String name;

    ArrayList <ObjContainer> rezultList = new ArrayList<ObjContainer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
