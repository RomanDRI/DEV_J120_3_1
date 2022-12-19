package Calculator;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JLabel label;
    private double number;
    private double number2;
    private int calculateOperation;
    private boolean equal;
    private double result;

    public MainFrame () {
        setTitle("Калькулятор");
        setSize(480, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container root = getContentPane();
        root.setLayout(new GridLayout(3,3));
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Label", Font.ITALIC,30));
        root.add(label);
        root.add(button());
        root.add(equalButton());
        setVisible(true);
    }

    private JPanel button() {
        JPanel panel = new JPanel(new GridLayout(4,4));

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonPlus = new JButton("+");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonMinus = new JButton("-");
        JButton button3 = new JButton("3");
        JButton button2 = new JButton("2");
        JButton button1 = new JButton("1");
        JButton buttonMultiply = new JButton("*");
        JButton button0 = new JButton("0");
        JButton buttonPoint = new JButton(".");
        JButton buttonC = new JButton("C");
        JButton buttonDivide = new JButton("/");

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonDivide);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMultiply);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMinus);

        panel.add(button0);
        panel.add(buttonPoint);
        panel.add(buttonC);
        panel.add(buttonPlus);

        button7.addActionListener(e -> inputValue(7));
        button8.addActionListener(e -> inputValue(8));
        button9.addActionListener(e -> inputValue(9));
        buttonPlus.addActionListener(e -> inputOperation("+"));
        button4.addActionListener(e -> inputValue(4));
        button5.addActionListener(e -> inputValue(5));
        button6.addActionListener(e -> inputValue(6));
        buttonMinus.addActionListener(e -> inputOperation("-"));
        button1.addActionListener(e -> inputValue(1));
        button2.addActionListener(e -> inputValue(2));
        button3.addActionListener(e -> inputValue(3));
        buttonMultiply.addActionListener(e -> inputOperation("*"));
        button0.addActionListener(e -> inputValue(0));
        buttonPoint.addActionListener(e -> inputOperation("."));
        buttonC.addActionListener(e -> inputOperation("C"));
        buttonDivide.addActionListener(e -> inputOperation("/"));
        return panel;
    }
    private JPanel equalButton() {
        JPanel panel = new JPanel(new GridLayout(1,1));
        JButton buttonEqual = new JButton("=");
        panel.add(buttonEqual);
        buttonEqual.addActionListener(e ->inputEqual());
        return panel;
    }

    private void inputValue(int value) {
        if (equal == true) label.setText("");
        equal = false;
        if (label.getText() == "Делить на ноль нельзя!") label.setText("");
        label.setText(label.getText() + value);

    }

    private void inputOperation(String operation) {
        if (operation == "+" || operation == "-" || operation == "*" || operation == "/") {
            number = Double.parseDouble(label.getText());
            label.setText("");
        }
        if (operation == "C") label.setText("");
        if (operation == ".") {
            int b = String.valueOf(label.getText()).lastIndexOf('.');
            if(b == -1) label.setText(label.getText() + ".");
            else label.setText(label.getText());
        }
            switch (operation) {
                case "+": {
                    calculateOperation = 1;
                    break;
                }
                case "-": {
                    calculateOperation = 2;
                    break;
                }
                case "*": {
                    calculateOperation = 3;
                    break;
                }
                case "/": {
                    calculateOperation = 4;
                    break;
                }

            }
    }

    private void inputEqual(){
        number2 = Double.parseDouble(label.getText());
        if(calculateOperation == 1) {
            result = number + number2;
        }
        if(calculateOperation == 2) {
            result = number - number2;
        }
        if(calculateOperation == 3) {
            result = number * number2;
        }
        if(calculateOperation == 4) {
            if (number2 == 0) label.setText("Делить на ноль нельзя!");
            else {
                result = number / number2;
                label.setText(String.valueOf(result));
            }
        }
        if(calculateOperation == 1 || calculateOperation == 2 || calculateOperation == 3) {
            label.setText(String.valueOf(result));
        }
        equal = true;
    }
}
