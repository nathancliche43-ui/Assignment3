package com.example.zoomanagementapplication.Model;
/**
 * Represents a generic component within a zoo management hierarchy,
 * such as a zoo section, habitat, or individual enclosure.
 */
public interface ZooComponent {
    /**
     * Returns the name of a given component.
     * @return the component's name
     */
    String getName();

    /**
     * Counts the total amount of animals present in a given enclosure.
     * @return the total amount of animals
     */
    int countAnimals();
}
