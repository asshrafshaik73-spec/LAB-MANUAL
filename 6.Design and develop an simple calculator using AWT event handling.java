import java.awt.*;

public class Calculator extends Frame {
    TextField t1 = new TextField(4), t2 = new TextField(4), r = new TextField(6);

    public Calculator() {
        setLayout(new FlowLayout());
        add(t1); add(t2); add(r);

        for (String op : new String[]{"+", "-", "*", "/"}) {
            Button b = new Button(op);
            b.addActionListener(e -> {
                double a = Double.parseDouble(t1.getText()), bVal = Double.parseDouble(t2.getText());
                r.setText("" + (op.equals("+") ? a + bVal : op.equals("-") ? a - bVal : op.equals("*") ? a * bVal : a / bVal));
            });
            add(b);
        }
        setSize(220, 150); setVisible(true);
    }

    public static void main(String[] args) { new Calculator(); }
}
