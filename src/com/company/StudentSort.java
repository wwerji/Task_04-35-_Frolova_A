package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentSort {
    /**
     * 35. Отсортировать студентов так, чтобы сначала сортировка шла по курсу, затем по группе и
     * только потом по фамилии (для этого необходимо соответствующим образом реализовать
     * интерфейс Comparable<Student> для класса Student).
     */
    static class Student implements Comparable<Student> {
        String surname;
        int course;
        int group;

        public Student(String surname, int course, int group) {
            this.surname = surname;
            this.course = course;
            this.group = group;
        }

        @Override
        public String toString() {
            return String.format("Course %s Group %s %s", course, group, surname);
        }

        @Override
        public int compareTo(Student o) {
            return this.surname.compareTo(o.surname);
        }

    }


    public static void demo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Добавьте ученика в список (Укажите сначала ФИО, затем курс и группу):");
        Student[] students = new Student[]
                {
                new Student("Дмитрова Лена Викторовна", 1, 3),
                new Student("Соколов Никита Алексеевич", 2, 4),
                new Student("Лукина Мария Васильевна", 1, 3),
                new Student("Ларина Мария Романовна", 1, 3),
                new Student("Петров Дмитрий Алексеевич", 2, 1),
                new Student("Соколов Алексей Петрович", 2, 4),
                new Student("Онешко Михаил Романович", 3, 2),
                new Student("Иванов Павел Константинович", 3, 1),
                new Student(scan.nextLine(), scan.nextInt(), scan.nextInt())
        };
        Arrays.sort(students, Comparator
                .comparing((Student s) -> s.course)
                .thenComparing((Student s) -> s.group)
                .thenComparing((Student s) -> s.surname));

        for (Student s : students) {
            System.out.println(s);
        }

    }
}

