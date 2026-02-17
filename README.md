# Student-Record-Manager
About This Project

This project is a simple Student Record Management System built in Java using a Binary Search Tree (BST).

The purpose of this project is to understand how data structures (especially BST) work in real-life scenarios. Instead of just storing numbers, we use a tree to manage student records efficiently.

Each student has:

Roll Number

Name

Marks

The roll number is used as the key to organize students inside the Binary Search Tree.

 Why I Made This
 
As a DSA project, I wanted to apply Binary Search Tree concepts in a practical way.
This project demonstrates:

How BST handles insertion and deletion
How searching becomes efficient using tree structure
How recursion is used in real programs

 What This Program Can Do

✔ Add a new student
✔ Search a student by roll number
✔ Delete a student
✔ Update student marks
✔ Display all students in sorted order
✔ Find the topper (highest marks)
✔ Exit safely

The program is completely menu-driven and runs in the console.

 Data Structure Used

Binary Search Tree (BST)

Recursion for tree operations

Students are stored based on roll number:

Smaller roll number → Left side

Larger roll number → Right side

When displaying students, an in-order traversal is used so records appear in ascending order.

 How to Run
Make sure Java is installed on your system.

Compile:
javac Student.java StudentRecordManager.java

Run:
java StudentRecordManager

 Example
--- Student Record Menu ---
1. Add Student
2. Search Student
3. Delete Student
4. Update Marks
5. Display All Students
6. Show Topper
7. Exit


Example output:

Roll: 1, Name: Ali, Marks: 85.5
Roll: 2, Name: Ahmed, Marks: 91.0
Roll: 3, Name: Sara, Marks: 78.0
Topper: Ahmed with 91.0 marks.

 Time Complexity (Average Case)

Insert → O(log n)
Search → O(log n)
Delete → O(log n)
Display → O(n)
Find Topper → O(n)

If the tree becomes unbalanced, worst-case time can become O(n).

 Future Improvements

In the future, this project can be improved by:

Using AVL Tree to keep the tree balanced
Adding file handling to save records permanently
Creating a GUI version
Connecting it with a database

 Author
 
Gotam Ladkani
DSA Project – Java

