package com.example.zoomanagementapplication;

import java.util.List;

public class ZooSection implements ZooComponent{
    private String aName;
    List<ZooComponent> aComponents;

    public ZooSection(String pName){
        setName(pName);
    }

    public void setName(String pName) {
        if (pName == null || pName.isEmpty()) {
            throw new IllegalArgumentException("Name of zoo section cannot be empty.");
        }
        this.aName = pName;
    }

    public String getName() {
        return this.aName;
    }

    @Override
    public int countAnimals() {
        int total = 0;
        for (ZooComponent component : this.aComponents) {
            total += component.countAnimals();
        }
        return total;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
