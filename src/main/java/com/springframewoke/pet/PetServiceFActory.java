package com.springframewoke.pet;

public class PetServiceFActory {

    public  PetService petService(String petType){
        switch (petType){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }


}
