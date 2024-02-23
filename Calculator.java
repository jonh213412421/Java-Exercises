import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    ScriptEngineManager manager;
    ScriptEngine engine;

    Font myFont = new Font("Arial", Font.BOLD, 30);

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

        // Initialize ScriptEngine
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
        System.out.println("Engine initialized: " + engine);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == decButton) {
                textfield.setText(textfield.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                textfield.setText(textfield.getText().concat("+"));
            }
            if (e.getSource() == subButton) {
                textfield.setText(textfield.getText().concat("-"));
            }
            if (e.getSource() == mulButton) {
                textfield.setText(textfield.getText().concat("*"));
            }
            if (e.getSource() == divButton) {
                textfield.setText(textfield.getText().concat("/"));
            }
            if (e.getSource() == equButton) {
                Object result = engine.eval(textfield.getText());
                double resultDouble = Double.parseDouble(result.toString());
                System.out.println("Result: " + resultDouble);
                textfield.setText(String.valueOf(resultDouble));
            }
            if (e.getSource() == clrButton) {
                textfield.setText("");
            }
            if (e.getSource() == delButton) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
            }
            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
        } catch (ScriptException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid expression", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
