package collections.task5;


import collections.task5.entities.Cat;
import collections.task5.entities.Dog;
import collections.task5.entities.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GenTest {
    public static void main(String[] args) {

        Cat[] cats1 = {new Cat()};
        Pet[] pets2 = cats1;

        List<Cat> cats = getCats();
        List<Pet> pets = new ArrayList<>(cats);
        Collections.copy(pets, cats);
        callPets(pets);
    }

    // можно заменить на <? extends Pet>       -->
    private static <T extends Pet> T callPets(List<T> pets) {
        for (T pet : pets) {
            System.out.println(pet);
            pet.feed();
            pet.call();
            if (pet instanceof Cat) {
                ((Cat) pet).meow();
            } else {
                ((Dog) pet).bark();
            }
        }
        return pets.get(0);
    }

    private static List<Cat> getCats() {
        List<Cat> result = new ArrayList<>();
        result.add(new Cat());
        return result;
    }
}
