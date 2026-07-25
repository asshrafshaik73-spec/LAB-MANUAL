import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel lblName, lblRoll, lblCourse;
    JTextField txtName, txtRoll;
    JComboBox<String> courseBox;
    JButton btnRegister, btnClear;

    public StudentRegistrationForm() {

        // Labels
        lblName = new JLabel("Student Name:");
        lblRoll = new JLabel("Roll Number:");
        lblCourse = new JLabel("Course:");

        // Text Fields
        txtName = new JTextField(20);
        txtRoll = new JTextField(20);

        // Combo Box
        String courses[] = {"BCA", "B.Sc", "B.Com", "B.Tech", "MCA"};
        courseBox = new JComboBox<>(courses);

        // Buttons
        btnRegister = new JButton("Register");
        btnClear = new JButton("Clear");

        // Event Handling
        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        // Layout
        setLayout(new GridLayout(4, 2, 10, 10));

        add(lblName);
        add(txtName);

        add(lblRoll);
        add(txtRoll);

        add(lblCourse);
        add(courseBox);

        add(btnRegister);
        add(btnClear);

        // Frame Settings
        setTitle("Student Registration Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegister) {

            String name = txtName.getText();
            String roll = txtRoll.getText();
            String course = (String) courseBox.getSelectedItem();

            JOptionPane.showMessageDialog(this,
                    "Student Registered Successfully!\n\n" +
                    "Name: " + name +
                    "\nRoll Number: " + roll +
                    "\nCourse: " + course);

        } else if (e.getSource() == btnClear) {

            txtName.setText("");
            txtRoll.setText("");
            courseBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
