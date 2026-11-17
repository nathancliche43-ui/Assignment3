package com.example.zoomanagementapplication.Model;

import java.util.List;

/**
 * Represents a composite section within a zoo that can contain other
 * {@link ZooComponent} elements, such as subsections or animal enclosures.
 */
public class ZooSection implements ZooComponent{
    private String aName;
    List<ZooComponent> aComponents;

    /**
     * Constructs a new {@code ZooSection} with a specified name.
     * @param pName name of the zoo section
     * @throws IllegalArgumentException if {@code pName} is {@code null} or empty
     */
    public ZooSection(String pName){
        setName(pName);
    }

    /**
     * Sets the name of the zoo section.
     * @param pName name of the zoo section
     * @throws IllegalArgumentException if {@code pName} is {@code null} or empty
     */
    public void setName(String pName) {
        if (pName == null || pName.isEmpty()) {
            throw new IllegalArgumentException("Name of zoo section cannot be empty.");
        }
        this.aName = pName;
    }

    /**
     * Returns the name of the zoo section.
     * @return the name of the zoo section
     */
    public String getName() {
        return this.aName;
    }

    /**
     * Returns the total amount of animals in a zoo section.
     * @return the total amount of animals
     */
    @Override
    public int countAnimals() {
        int total = 0;
        for (ZooComponent component : this.aComponents) {
            total += component.countAnimals();
        }
        return total;
    }

    /**
     * Returns a string of the zoo section's name.
     * @return the name of the zoo section
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
