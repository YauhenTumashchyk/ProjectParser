package com.tumashchick.pp.container;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjContainer {

    private String name;
    public List<ObjContainer> rezultList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjContainer> getRezultList() {
        return rezultList;
    }

    public void setRezultList(List<ObjContainer> rezultList) {
        this.rezultList = rezultList;
    }

}
