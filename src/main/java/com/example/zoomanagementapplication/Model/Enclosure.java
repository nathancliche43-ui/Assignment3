package com.example.zoomanagementapplication.Model;

import com.example.zoomanagementapplication.Model.ZooComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Enclosure implements ZooComponent {
    /**
     * creates variable
     */
    private String aName;
    /**
     * List get the animals
     */
    private final List<Animal> aAnimal = new ArrayList<>();

    /**
     *
     * @param pName the name of the enclosure
     */
    public Enclosure(String pName){
    this.setName(pName);
}

    /**
     *
     * @param pName the new name
     */
    public void setName(String pName){
    if (pName == null || pName.isEmpty()){
        throw new IllegalArgumentException("Name of enclosure cannot be empty");
    }
    this.aName = pName;
}

    /**
     *
     * @return return the name of the enclosure
     */
    @Override
    public String getName() {
    return this.aName;
}

    /**
     *
     * @param pAnimal the animal to add
     * @throws throws an error if null
     */
    public void addAnimal(Animal pAnimal){
    if (pAnimal == null) {
        throw new IllegalArgumentException("Animal can't be empty");
    }
    this.aAnimal.add(pAnimal);
}

    /**
     *
     * @param pAnimal the animal to remove
     * @return returns the new enclosure with the animal removed
     */
    public boolean removeAnimal(Animal pAnimal){
    return this.aAnimal.remove(pAnimal);
}

    /**
     *
     * @return the list
     */
    public List<Animal> getAnimal(){
    return Collections.unmodifiableList(this.aAnimal);
}

    /**
     *
     * @return returns the animal count
     */
    @Override
    public int countAnimals(){
    return this.aAnimal.size();
}

    /**
     *
     * @return returns the name of the enclosure
     */
    @Override
    public String toString(){
    return this.getName();
}

}
