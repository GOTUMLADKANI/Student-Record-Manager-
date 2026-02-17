import java.util.Scanner;

public class StudentRecordManager {
    private Student root;

    // Insert student
    public Student insert(Student root, int roll, String name, float marks) {
        if (root == null) return new Student(roll, name, marks);
        if (roll < root.roll) root.left = insert(root.left, roll, name, marks);
        else if (roll > root.roll) root.right = insert(root.right, roll, name, marks);
        return root;
    }

    // Search student
    public Student search(Student root, int roll) {
        if (root == null || root.roll == roll) return root;
        if (roll < root.roll) return search(root.left, roll);
        return search(root.right, roll);
    }

    // Find minimum node (used in delete)
    public Student findMin(Student root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // Delete student
    public Student delete(Student root, int roll) {
        if (root == null) return null;
        if (roll < root.roll) root.left = delete(root.left, roll);
        else if (roll > root.roll) root.right = delete(root.right, roll);
        else {
            // One or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Two children
            Student temp = findMin(root.right);
            root.roll = temp.roll;
            root.name = temp.name;
            root.marks = temp.marks;
            root.right = delete(root.right, temp.roll);
        }
        return root;
    }

    // In-order display
    public void inorder(Student root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Roll: " + root.roll + ", Name: " + root.name + ", Marks: " + root.marks);
            inorder(root.right);
        }
    }

    // Update marks
    public boolean updateMarks(Student root, int roll, float newMarks) {
        Student student = search(root, roll);
        if (student != null) {
            student.marks = newMarks;
            return true;
        }
        return false;
    }

    // Find topper
    public Student findTopper(Student root) {
        if (root == null) return null;
        Student leftTop = findTopper(root.left);
        Student rightTop = findTopper(root.right);

        Student top = root;
        if (leftTop != null && leftTop.marks > top.marks) top = leftTop;
        if (rightTop != null && rightTop.marks > top.marks) top = rightTop;
        return top;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordManager manager = new StudentRecordManager();

        while (true) {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Display All Students");
            System.out.println("6. Show Topper");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();
                    manager.root = manager.insert(manager.root, roll, name, marks);
                    break;
                case 2:
                    System.out.print("Enter Roll to Search: ");
                    roll = sc.nextInt();
                    Student found = manager.search(manager.root, roll);
                    if (found != null)
                        System.out.println("Found: " + found.name + " with " + found.marks + " marks.");
                    else
                        System.out.println("Student not found.");
                    break;
                case 3:
                    System.out.print("Enter Roll to Delete: ");
                    roll = sc.nextInt();
                    manager.root = manager.delete(manager.root, roll);
                    System.out.println("Deleted if existed.");
                    break;
                case 4:
                    System.out.print("Enter Roll to Update: ");
                    roll = sc.nextInt();
                    System.out.print("Enter New Marks: ");
                    marks = sc.nextFloat();
                    if (manager.updateMarks(manager.root, roll, marks))
                        System.out.println("Marks updated.");
                    else
                        System.out.println("Student not found.");
                    break;
                case 5:
                    System.out.println("All Student Records:");
                    manager.inorder(manager.root);
                    break;
                case 6:
                    Student topper = manager.findTopper(manager.root);
                    if (topper != null)
                        System.out.println("Topper: " + topper.name + " with " + topper.marks + " marks.");
                    else
                        System.out.println("No students found.");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}