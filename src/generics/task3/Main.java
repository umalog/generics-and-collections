package generics.task3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Long, Cat> catMap = new HashMap<>();
    static {
        catMap.put(1L, new Cat("Barsik"));
        catMap.put(2L, new Cat("Pushok"));
        catMap.put(3L, new Cat("Tisha"));
    }

    public static void main(String[] args) {
        MyStore<Long, Cat> animalStore = new MyStore<>();

        animalStore.putAll(catMap);
        animalStore.store.values().stream().forEach(a -> a.makeNoize());

//        Map<Long, Animal> map = Collections.singletonMap(1L, new Animal("Vasiliy Petrovich"));
//        animalStore.putAll(map); // String на наследуется от Animal


    }
}
