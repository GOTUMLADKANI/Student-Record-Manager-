public class Student {
    int roll;
    String name;
    float marks;
    Student left, right;

    public Student(int roll, String name, float marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.left = this.right = null;
    }
}
