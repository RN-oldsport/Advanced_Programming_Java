package BMI;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("BMI App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 400);
        frame.setVisible(true);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel panelStart = new JPanel(new GridBagLayout());
        JPanel panelCalculation = new JPanel(new GridBagLayout());
        mainPanel.add(panelStart, "START");
        mainPanel.add(panelCalculation, "CALCULATION");

        frame.add(mainPanel);

        // page 1
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel intro = new JLabel("Welcome!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelStart.add(intro, gbc);

        JButton buttonStart = new JButton("Start");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelStart.add(buttonStart, gbc);

        buttonStart.addActionListener(e -> cardLayout.show(mainPanel, "CALCULATION"));

        // page 2
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 10, 10, 10);

        JLabel labelHeight = new JLabel("Height (cm)");
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panelCalculation.add(labelHeight, gbc2);

        JTextField fieldHeight = new JTextField(10);
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        panelCalculation.add(fieldHeight, gbc2);

        JLabel labelWeight = new JLabel("Weight (kg)");
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        panelCalculation.add(labelWeight, gbc2);

        JTextField fieldWeight = new JTextField(10);
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        panelCalculation.add(fieldWeight, gbc2);

        JButton buttonCalculate = new JButton("Calculate");
        gbc2.gridx = 0;
        gbc2.gridy = 10;
        panelCalculation.add(buttonCalculate, gbc2);

        JLabel labelResult = new JLabel();
        gbc2.gridx = 0;
        gbc2.gridy = 12;
        panelCalculation.add(labelResult, gbc2);

        buttonCalculate.addActionListener(new ButtonCalcListener(fieldHeight, fieldWeight, labelResult));


        panelStart.setBackground(Color.GRAY);
        panelCalculation.setBackground(Color.GRAY);
//        intro.setOpaque(true);
//        labelResult.setOpaque(true);
        labelResult.setBackground(new Color(220, 240, 220));

    }
}



class ButtonCalcListener implements ActionListener {
    JTextField fieldHeight;
    JTextField fieldWeight;
    JLabel labelResult;

    public ButtonCalcListener(JTextField fieldHeight, JTextField fieldWeight, JLabel labelResult) {
        this.fieldHeight = fieldHeight;
        this.fieldWeight = fieldWeight;
        this.labelResult = labelResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double h = Double.parseDouble(fieldHeight.getText()) / 100;
        double w = Double.parseDouble(fieldWeight.getText());
        double bmi = w / Math.pow(h, 2);

        String text = result.text(bmi);
        labelResult.setText(text);
    }
}


class result {

    public static String text(double bmi) {
        return String.format("Your BMI: %.2f (%s)", bmi, status(bmi));
    }

    public static String status(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 24.9) {
            return "Normal weight";
        }
        if (bmi < 29.9) {
            return "Overweight";
        }
        return "Obesity";
    }
}
