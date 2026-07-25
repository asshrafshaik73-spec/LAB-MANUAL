import java.util.*;

class Student {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Course: " + course;
    }
}

public class StudentRecordManagement {

    static ArrayList<Student> studentList = new ArrayList<>();
    static HashMap<Integer, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    if (studentMap.containsKey(roll)) {
                        System.out.println("Student already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student s = new Student(roll, name, course);

                    studentList.add(s);
                    studentMap.put(roll, s);

                    System.out.println("Student Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    if (studentMap.containsKey(updateRoll)) {
                        Student st = studentMap.get(updateRoll);

                        System.out.print("Enter New Name: ");
                        st.name = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        st.course = sc.nextLine();

                        System.out.println("Student Record Updated.");
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();

                    if (studentMap.containsKey(searchRoll)) {
                        System.out.println(studentMap.get(searchRoll));
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    int deleteRoll = sc.nextInt();

                    if (studentMap.containsKey(deleteRoll)) {
                        Student student = studentMap.remove(deleteRoll);
                        studentList.remove(student);
                        System.out.println("Student Record Deleted.");
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 5:
                    if (studentList.isEmpty()) {
                        System.out.println("No Student Records Available.");
                    } else {
                        System.out.println("\n----- Student Records -----");
                        for (Student student : studentList) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
