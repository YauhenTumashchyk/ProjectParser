package com.tumash.pp.objects;

import java.util.ArrayList;

public abstract class Container {

    String name;

    ArrayList <Container> rezultList = new ArrayList<Container>();

    public String getMane() {
        return name;
    }

    public void setMane(String mane) {
        this.name = mane;
    }
}
