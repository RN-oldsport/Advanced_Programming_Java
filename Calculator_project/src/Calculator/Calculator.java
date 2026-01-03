package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numbers = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton deciButton, delButton, equButton, clrButton, negButton;
    JPanel panel;
    boolean isDeciButtonPressed = false;

    Font font = new Font("Estrangelo Edessa", Font.BOLD,25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    Calculator(){
        frame = new JFrame("Calculater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,70);
        textfield.setFont(font);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        delButton = new JButton("DEL");
        clrButton = new JButton("C");
        negButton = new JButton("(+/-)");
        deciButton = new JButton(".");
        equButton = new JButton("=");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = deciButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }



        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.RED);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);

        panel.add(deciButton);
        panel.add(numbers[0]);
        panel.add(equButton);
        panel.add(divButton);
        frame.add(panel);

        negButton.setBounds(50,430,100,40);
        delButton.setBounds(155,430,100,40);
        clrButton.setBounds(260,430,100,40);

        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numbers[i]){
                textfield.setText(textfield.getText() + numbers[i].getText());
            }
        }

        if(e.getSource() == deciButton && !isDeciButtonPressed && !textfield.getText().isEmpty()){
            {
                isDeciButtonPressed = true;
                textfield.setText(textfield.getText() + ".");
            }
        }

        if(e.getSource() == clrButton){
            textfield.setText("");
            isDeciButtonPressed = false;
        }


        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            operator = '+';
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            operator = '-';
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            operator = '*';
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            operator = '/';
        }

        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == delButton){
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length()-1; i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }

        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textfield.setText("" + String.valueOf(result));
        }


    }

}