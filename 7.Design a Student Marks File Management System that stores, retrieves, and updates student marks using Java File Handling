import java.io.*;
import java.util.*;

public class StudentMarks {
    static String FILE = "marks.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Store  2. Retrieve  3. Update  4. Exit");
            int choice = sc.nextInt();
            if (choice == 1) add(sc);
            else if (choice == 2) view();
            else if (choice == 3) update(sc);
            else break;
        }
    }

    // 1. Store
    static void add(Scanner sc) throws IOException {
        System.out.print("Roll and Marks: ");
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(sc.next() + " " + sc.nextInt() + "\n");
        fw.close();
        System.out.println("Saved!");
    }

    // 2. Retrieve
    static void view() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) return;
        Scanner reader = new Scanner(f);
        System.out.println("Roll\tMarks");
        while (reader.hasNext()) 
            System.out.println(reader.next() + "\t" + reader.next());
        reader.close();
    }

    // 3. Update
    static void update(Scanner sc) throws IOException {
        System.out.print("Roll to update & New Marks: ");
        String target = sc.next(), newMarks = sc.next(), data = "";
        Scanner reader = new Scanner(new File(FILE));
        
        while (reader.hasNext()) {
            String roll = reader.next(), marks = reader.next();
            data += roll + " " + (roll.equals(target) ? newMarks : marks) + "\n";
        }
        reader.close();

        FileWriter fw = new FileWriter(FILE);
        fw.write(data);
        fw.close();
        System.out.println("Updated!");
    }
}
