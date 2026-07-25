import java.sql.*;
import java.util.Scanner;

public class StudentDatabase {

    // Database URL, Username and Password
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "root";   // Change as per your MySQL password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {

                System.out.println("\n===== Student Database Management =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // Insert
                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO student VALUES (?, ?, ?)");

                        ps.setInt(1, roll);
                        ps.setString(2, name);
                        ps.setString(3, course);

                        int i = ps.executeUpdate();

                        if (i > 0)
                            System.out.println("Student Record Inserted Successfully.");
                        break;

                    case 2:
                        // Display
                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery("SELECT * FROM student");

                        System.out.println("\nRollNo\tName\tCourse");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("rollno") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("course"));
                        }
                        break;

                    case 3:
                        // Update
                        System.out.print("Enter Roll Number to Update: ");
                        int r = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        PreparedStatement ps2 = con.prepareStatement(
                                "UPDATE student SET name=?, course=? WHERE rollno=?");

                        ps2.setString(1, newName);
                        ps2.setString(2, newCourse);
                        ps2.setInt(3, r);

                        int update = ps2.executeUpdate();

                        if (update > 0)
                            System.out.println("Record Updated Successfully.");
                        else
                            System.out.println("Student Not Found.");

                        break;

                    case 4:
                        // Delete
                        System.out.print("Enter Roll Number to Delete: ");
                        int rollDelete = sc.nextInt();

                        PreparedStatement ps3 = con.prepareStatement(
                                "DELETE FROM student WHERE rollno=?");

                        ps3.setInt(1, rollDelete);

                        int delete = ps3.executeUpdate();

                        if (delete > 0)
                            System.out.println("Record Deleted Successfully.");
                        else
                            System.out.println("Student Not Found.");

                        break;

                    case 5:
                        con.close();
                        System.out.println("Thank You!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
