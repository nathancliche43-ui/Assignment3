//package com.example.zoomanagementapplication;
//import com.example.zoomanagementapplication.Model.ZooSection;
//
///**
// * The {@code ImportHelper} class is a utility class responsible for
// * constructing and returning a preconfigured zoo structure used in
// * the Zoo Management System (ZMS) demo.
// *
// * <p>This class uses the Composite Design Pattern by organizing
// * multiple {@link Enclosure} objects (leaf nodes) and
// * {@link ZooSection} objects (composite nodes) into a hierarchical
// * structure of zoo sections and enclosures.</p>
// *
// * <p>The generated structure is stored inside a {@link ZooService}
// * instance, which acts as the entry point to the application's model.</p>
// *
// * <p>Example usage:</p>
// * <pre>{@code
// * ZooService zooService = ImportHelper.createZooService();
// *
// * ZooSection rootSection = zooService.getRootSection();
// * System.out.println(rootSection.countAnimals());
// * }</pre>
// *
// * @author Matthias Harte
// * @version 3.0
// */
//public final class ImportHelper {
//
//    /**
//     * Prevent instantiation of this utility class.
//     */
//    private ImportHelper() {
//    }
//
//    /**
//     * Creates and returns a {@link ZooService} containing a
//     * preconfigured zoo structure. The zoo contains two major
//     * sections: Big Cats and Birds.
//     *
//     * <p>The resulting hierarchy looks like this:</p>
//     *
//     * <pre>
//     * Zoo
//     * ├── Big Cats
//     * │   ├── Lions
//     * │   │   ├── Simba
//     * │   │   ├── Mufasa
//     * │   │   └── Nala
//     * │   ├── Tigers
//     * │   │   ├── Tiger Habitat
//     * │   │   │   ├── Rajah
//     * │   │   │   └── Shere Khan
//     * │   │   └── Tiger Cubs
//     * │   │       ├── Tala
//     * │   │       ├── Ravi
//     * │   │       ├── Kali
//     * │   │       └── Indra
//     * │   └── Cougars
//     * │       ├── Sierra
//     * │       ├── Rocky
//     * │       ├── Luna
//     * │       └── Lenny
//     * │
//     * └── Birds
//     *     ├── Eagles
//     *     │   ├── Freedom
//     *     │   ├── Majesty
//     *     │   └── Talon
//     *     ├── Parrots
//     *     │   ├── Rio
//     *     │   ├── Mango
//     *     │   └── Kiwi
//     *     └── Penguins
//     *         ├── Pingu
//     *         ├── Skipper
//     *         ├── Rico
//     *         └── Kowalski
//     * </pre>
//     *
//     * <p>In this hierarchy:</p>
//     * <ul>
//     *     <li>{@link ZooSection} objects are composite nodes that can
//     *     contain other {@link ZooSection}s and {@link Enclosure}s.</li>
//     *     <li>{@link Enclosure} objects are leaf nodes that store animals.</li>
//     *     <li>The root {@link ZooSection} is "Zoo".</li>
//     * </ul>
//     *
//     * @return an initialized {@link ZooService} containing the
//     *         complete zoo structure
//     */
//    public static ZooService createZooService() {
//
//        // ==========================================================
//        // BIG CATS
//        // ==========================================================
//
//        Enclosure lions = new Enclosure("Lions");
//        lions.addAnimal(new Lion("Simba", 3));
//        lions.addAnimal(new Lion("Mufasa", 8));
//        lions.addAnimal(new Lion("Nala", 3));
//
//        Enclosure tigerHabitat = new Enclosure("Tiger Habitat");
//        tigerHabitat.addAnimal(new Tiger("Rajah", 3));
//        tigerHabitat.addAnimal(new Tiger("Shere Khan", 3));
//
//        Enclosure tigerCubs = new Enclosure("Tiger Cubs");
//        tigerCubs.addAnimal(new Tiger("Tala", 5));
//        tigerCubs.addAnimal(new Tiger("Ravi", 0));
//        tigerCubs.addAnimal(new Tiger("Kali", 0));
//        tigerCubs.addAnimal(new Tiger("Indra", 0));
//
//        ZooSection tigers = new ZooSection("Tigers");
//        tigers.addComponent(tigerHabitat);
//        tigers.addComponent(tigerCubs);
//
//        Enclosure cougars = new Enclosure("Cougars");
//        cougars.addAnimal(new Cougar("Sierra", 3));
//        cougars.addAnimal(new Cougar("Rocky", 3));
//        cougars.addAnimal(new Cougar("Luna", 2));
//        cougars.addAnimal(new Cougar("Lenny", 1));
//
//        ZooSection bigCats = new ZooSection("Big Cats");
//        bigCats.addComponent(lions);
//        bigCats.addComponent(tigers);
//        bigCats.addComponent(cougars);
//
//        // ==========================================================
//        // BIRDS
//        // ==========================================================
//
//        Enclosure eagles = new Enclosure("Eagles");
//        eagles.addAnimal(new Eagle("Freedom", 6));
//        eagles.addAnimal(new Eagle("Majesty", 4));
//        eagles.addAnimal(new Eagle("Talon", 7));
//
//        Enclosure parrots = new Enclosure("Parrots");
//        parrots.addAnimal(new Parrot("Rio", 2));
//        parrots.addAnimal(new Parrot("Mango", 5));
//        parrots.addAnimal(new Parrot("Kiwi", 3));
//
//        Enclosure penguins = new Enclosure("Penguins");
//        penguins.addAnimal(new Penguin("Pingu", 4));
//        penguins.addAnimal(new Penguin("Skipper", 7));
//        penguins.addAnimal(new Penguin("Rico", 6));
//        penguins.addAnimal(new Penguin("Kowalski", 8));
//
//        ZooSection birds = new ZooSection("Birds");
//        birds.addComponent(eagles);
//        birds.addComponent(parrots);
//        birds.addComponent(penguins);
//
//        // ==========================================================
//        // ROOT ZOO SECTION
//        // ==========================================================
//
//        ZooSection zoo = new ZooSection("Zoo");
//        zoo.addComponent(bigCats);
//        zoo.addComponent(birds);
//
//        // ==========================================================
//        // SERVICE
//        // ==========================================================
//
//        ZooService zooService = new ZooService();
//        zooService.setRootSection(zoo);
//
//        return zooService;
//    }
//}