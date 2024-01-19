package main.java.com.magicvet.model;

public class Cat extends Pet{
    public Cat(){}
    public Cat(String name, String age, HealthState state){
        setName(name);
        setAge(age);
        setHealthState(state);
    }
}
