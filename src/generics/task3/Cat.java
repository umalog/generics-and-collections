package generics.task3;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public void makeNoize() {
        System.out.println(
                "Cat is meowing");
    }
}
