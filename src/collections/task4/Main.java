package collections.task4;


import collections.task4.entity.Skill;
import collections.task4.entity.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = getStudent();

        System.out.println("________for loop________");
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            if (i == 2) {
                students.remove(i);
            }
            System.out.println(stu.getFirstName() + " by number " + i);
        }
        System.out.println("students.size = " + students.size());

        System.out.println("\n________for-each loop________");
        int i = 0;
        for (Student student : students) {
            if (++i == 1) {
                students.remove(i); // ConcurrentModificationException
            }
            System.out.println(student.getFirstName() + " by number " + i);
        }
        System.out.println("students.size = " + students.size());

        System.out.println("\n________Iterator loop________");
        Iterator it = students.iterator();
        i = 0;
        while (it.hasNext()) {
            Student stu = (Student) it.next();
            if (++i == 1) {
                it.remove();
            }
            System.out.println(stu.getFirstName() + " by number " + i);
        }
        System.out.println("students.size = " + students.size());

        System.out.println("\n________Map________");
        Map<Student, Skill> studSkills = generateSkills(students);
        Student x = students.get(0);
        studSkills.remove(x);
        System.out.println(x.getLastName() + " : " + studSkills.get(x));

    }

    private static Map generateSkills(List<Student> students) {
        Map<Student, Skill> result = new HashMap<>();

        for (Student student : students) {
            result.put(student, new Skill("Java", (int) (Math.random() * 10)));
        }
        return Collections.unmodifiableMap(result);
    }

    private static List<Student> getStudent() {
        return new ArrayList<>(Arrays.asList(
                new Student("John", "Connor"),
                new Student("Ivan", "Ivanov"),
                new Student("Vlad", "Vladov"),
                new Student("John", "Smith")
        ));
    }
}
