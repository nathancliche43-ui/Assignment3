package com.example.zoomanagementapplication.Model;
public class Parrot extends Animal {
    /**
     * Constructs a new {@code Animal} with the specified name and age.
     *
     * @param pName the name of the animal
     * @param pAge  the age of the animal in years; must be non-negative
     * @throws IllegalArgumentException if {@code pAge} is negative or {@code pName} is empty
     */
    public Parrot(String pName, double pAge) {
        super(pName, pAge);
    }
}

