package collections.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List l1 = new ArrayList<>();
        l1.add(12);
        l1.add("OOOPS");
        dump(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(14);
        l2.add(15);
        dump(l2);
    }

    static void dump(List<?> c) {
        for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
            Object o = i.next();
            System.out.println(o);
        }
    }
}
