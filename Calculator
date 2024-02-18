import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    private JTextField display;
    private Calculator() {
        super("Basic Calculator");
        setLayout(new BorderLayout());
        //create display
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        //add buttons
        JPanel panel = new JPanel(new GridLayout(4,3));
        for (int i = 1; i <= 9; i++) {
            addButton(panel, String.valueOf(i));
        }
        addButton(panel, "0");
        addButton(panel, ".");
        add(panel, BorderLayout.CENTER);
        JPanel operations = new JPanel(new GridLayout(4,1));
        addButton(operations, "+");
        addButton(operations, "-");
        addButton(operations, "/");
        addButton(operations, "*");
        add(operations, BorderLayout.EAST);
        JPanel control = new JPanel(new GridLayout(2,1));
        JButton equal = new JButton("=");
        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        control.add(equal);
        JButton clear = new JButton("C");
        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearDisplay();
            }
        });
        control.add(clear);
        add(control, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    private void addButton(Container container, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appendToDisplay(text);
            }
        });
        container.add(button);
    }

    private void appendToDisplay(String text) {
        display.setText(display.getText() + text);
    }

    private void calculate() {
        try {
            String expression = display.getText();
            //double result = evaluateExpression(expression);
            //display.setText(String.valueOf(result));
        } catch (ArithmeticException | NumberFormatException ex) {
            display.setText("Error");
        }
    }

    //private double evaluateExpression(String expression) {
        //return new DoubleEvaluator().evaluate(expression);
    //}

    private void clearDisplay() {
        display.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }

}
