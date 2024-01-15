package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS),
                new Dog(Dog.S),
        };

        Pet[] pets = {
                new Cat("Milo","2"),
                new Dog("Abbey","4"),
                new Cat("Skip","1"),
                new Dog("Candy","8"),
                new Cat("Gracie","3"),

        };

        Arrays.sort(dogs, new DogSizeComparator());
        System.out.println("Sort by size: ");
        for(Dog dog : dogs){
            System.out.println("\t" + dog.getSize());
        }

        Arrays.sort(pets, new PetNameComparator());
        System.out.println("Sort by name: ");
        for(Pet pet: pets){
            System.out.println("\t"  + pet.getName());
        }

        Arrays.sort(pets, new PetAgeComparator());
        System.out.println("Sort by age: ");
        for(Pet pet: pets){
            System.out.println("\t" + pet.getAge());
        }
    }
}
