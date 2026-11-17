package com.example.zoomanagementapplication.Model;

import com.example.zoomanagementapplication.Model.ZooComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Enclosure implements ZooComponent {
    
    private String aName;

private final List<Animal> aAnimal = new ArrayList<>();

public Enclosure(String pName){
    this.setName(pName);
}

public void setName(String pName){
    if (pName == null || pName.isEmpty()){
        throw new IllegalArgumentException("Name of enclosure cannot be empty");
    }
    this.aName = pName;
}

@Override
    public String getName() {
    return this.aName;
}

public void addAnimal(Animal pAnimal){
    if (pAnimal == null) {
        throw new IllegalArgumentException("Animal can't be empty");
    }
    this.aAnimal.add(pAnimal);
}
public boolean removeAnimal(Animal pAnimal){
    return this.aAnimal.remove(pAnimal);
}

public List<Animal> getAnimal(){
    return Collections.unmodifiableList(this.aAnimal);
}

@Override
    public int countAnimals(){
    return this.aAnimal.size();
}

@Override
    public String toString(){
    return this.getName();
}

}
