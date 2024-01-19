package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S),
        };

        Pet[] pets = {
                new Cat("Milo","2", Pet.HealthState.LIGHT),
                new Dog("Abbey","4", Pet.HealthState.BAD),
                new Cat("Skip","1", Pet.HealthState.PERFECT),
                new Dog("Candy","8", Pet.HealthState.MEDIUM),
                new Cat("Gracie","3", Pet.HealthState.VERYBAD),

        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });
        System.out.println("Sort by size: ");
        for(Dog dog : dogs){
            System.out.println("\t" + dog.getSize());
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sort by name: ");
        for(Pet pet: pets){
            System.out.println("\t"  + pet.getName());
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
            }
        });
        System.out.println("Sort by age: ");
        for(Pet pet: pets){
            System.out.println("\t" + pet.getAge());
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });
        System.out.println("Sort by health state: ");
        for(Pet pet: pets){
            System.out.println("\t" + pet.getName() + " - " + pet.getHealthState());
        }

        System.out.println("\nRegistration date pet");
        System.out.println("\t" + new Cat());

        System.out.println("\nRegistration date client");
        System.out.println("\t" + new Client());
    }
}
