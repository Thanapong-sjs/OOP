import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    
    private JTextField displayField;
    private JButton btnC, btnCE, btnDiv, btnMul;
    private JButton btn1, btn2, btn3, btnAdd;
    private JButton btn4, btn5, btn6, btnSub;
    private JButton btn7, btn8, btn9, btnEqual;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator(String title) {
        super(title);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 400);
        setLayout(new BorderLayout(5, 5));

        displayField = new JTextField();
        displayField.setFont(new Font("SansSerif", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        btnC = new JButton("C");
        btnCE = new JButton("CE");
        btnDiv = new JButton("/");
        btnMul = new JButton("*");

        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btnAdd = new JButton("+");

        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btnSub = new JButton("-");

        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnEqual = new JButton("=");

        JButton[] buttons = {
            btnC, btnCE, btnDiv, btnMul,
            btn1, btn2, btn3, btnAdd,
            btn4, btn5, btn6, btnSub,
            btn7, btn8, btn9, btnEqual
        };

        for (JButton btn : buttons) {
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.addActionListener(this); 
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.matches("[0-9]")) {
                displayField.setText(displayField.getText() + command);
            } 
            else if (command.equals("C") || command.equals("CE")) {
                displayField.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
            } 

            else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                num1 = Double.parseDouble(displayField.getText()); // เก็บค่าตัวเลขชุดแรก
                operator = command.charAt(0);
                displayField.setText("");
            } 
            else if (command.equals("=")) {
                num2 = Double.parseDouble(displayField.getText());
                
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': result = num1 / num2; break;
                }
                
                if (result == (long) result) {
                    displayField.setText(String.format("%d", (long) result));
                } else {
                    displayField.setText(String.valueOf(result));
                }
            }
        } catch (NumberFormatException ex) {
            displayField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Calculator("CALCULATOR");
    }
}