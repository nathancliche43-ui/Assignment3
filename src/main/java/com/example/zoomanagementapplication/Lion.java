package com.example.zoomanagementapplication;

import com.example.zoomanagementapplication.Model.Animal;

public class Lion extends Animal {
    /**
     * Constructs a new {@code Animal} with the specified name and age.
     *
     * @param pName the name of the animal
     * @param pAge  the age of the animal in years; must be non-negative
     * @throws IllegalArgumentException if {@code pAge} is negative or {@code pName} is empty
     */
    public Lion(String pName, double pAge) {
        super(pName, pAge);
    }
}
