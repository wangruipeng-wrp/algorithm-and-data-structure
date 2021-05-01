package LinearSearch;

class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.name.equals(student.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("张三"),
                new Student("李四"),
                new Student("王五")
        };

        System.out.println(LinearSearch.search(students, new Student("张三")));
        System.out.println(LinearSearch.searchByRecursion(students, new Student("张三")));
    }
}
