package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JButton[][] b = new JButton[7][5];
    JLabel lb1, lb2, exp;

    JMenuBar mb;
    JMenu file, help;
    JMenuItem exit, about;

    double res = 0.0, temp = 0.0;
    int shiftCount = 0;
    String equ = "", op = "";

    Main() {
        setLayout(new FlowLayout());

        mb = new JMenuBar();

        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.setPreferredSize(new Dimension(40, 25));
        exit.addActionListener(e -> System.exit(0));
        file.setFont(new Font("Arial", Font.PLAIN, 18));
        file.setPreferredSize(new Dimension(40, 25));
        file.add(exit);
        mb.add(file);

        help = new JMenu("Help");
        about = new JMenuItem("About");
        help.setFont(new Font("Arial", Font.PLAIN, 18));
        help.setPreferredSize(new Dimension(50, 25));
        about.addActionListener(e -> JOptionPane.showMessageDialog(null, "<html><font size='6' face='arial'>This is a effort from: Ritesh Kudalkar and team.</font></html>", "About", JOptionPane.INFORMATION_MESSAGE));
        about.setFont(new Font("Arial", Font.PLAIN, 18));
        about.setPreferredSize(new Dimension(60, 25));
        help.add(about);

        mb.add(help);
        mb.setLocation(0, 0);
        setJMenuBar(mb);

        labels();
        buttons();

    }

    public static void main(String[] args) {
        Main ob = new Main();
        ob.setVisible(true);
        ob.setSize(405, 570);
        ob.setResizable(false);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setBackground(new Color(215, 215, 215));
        ob.setTitle("Calculator");

    }

    void buttons() {
        b[6][2] = new JButton("0");
        b[5][1] = new JButton("1");
        b[5][2] = new JButton("2");
        b[5][3] = new JButton("3");
        b[4][1] = new JButton("4");
        b[4][2] = new JButton("5");
        b[4][3] = new JButton("6");
        b[3][1] = new JButton("7");
        b[3][2] = new JButton("8");
        b[3][3] = new JButton("9");
        b[0][0] = new JButton("<html>x<sup>2</sup></html>");
        b[0][1] = new JButton("<html>x<sup>n</sup></html>");
        b[0][2] = new JButton("sin");
        b[0][3] = new JButton("cos");
        b[0][4] = new JButton("tan");
        b[1][0] = new JButton("\u221A");
        b[1][1] = new JButton("<html>10<sup>x</sup></html>");
        b[1][2] = new JButton("log");
        b[1][3] = new JButton("1/x");
        b[1][4] = new JButton("mod");
        b[2][0] = new JButton("\u03c0");
        b[2][1] = new JButton("CE");
        b[2][2] = new JButton("C");

        ImageIcon clr = new ImageIcon(getClass().getResource("clr.png"));
        Image clrImage = clr.getImage();
        clr = new ImageIcon(clrImage.getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH));
        b[2][3] = new JButton(clr);

        b[2][4] = new JButton("/");

        ImageIcon shift = new ImageIcon(getClass().getResource("shift.png"));
        Image shiftImg = shift.getImage();
        shift = new ImageIcon(shiftImg.getScaledInstance(30,30, Image.SCALE_SMOOTH));
        b[3][0] = new JButton(shift);
        b[3][4] = new JButton("x");
        b[4][0] = new JButton("n!");
        b[4][4] = new JButton("-");
        b[5][0] = new JButton("\u00B1");
        b[5][4] = new JButton("+");
        b[6][0] = new JButton("(");
        b[6][1] = new JButton(")");
        b[6][3] = new JButton(".");
        b[6][4] = new JButton("=");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                b[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                b[i][j].setBorder(null);
                b[i][j].setPreferredSize(new Dimension(70, 45));
                String c = b[i][j].getText();
                if (c.equals("0") || c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9"))
                    b[i][j].setBackground(new Color(250, 250, 250));
                else
                    b[i][j].setBackground(new Color(210, 210, 210));

                b[i][j].setLocation(10 + 85 * j, 200 + i * 55);
                add(b[i][j]);
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                String c = b[i][j].getText();
                if (c.equals("=")) {
                    b[i][j].addActionListener(e -> {
                        switch (op) {
                            case "+":
                                equ = equ + Double.parseDouble(lb1.getText());
                                exp.setText(equ);
                                res = temp + Double.parseDouble(lb1.getText());
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "-":
                                equ = equ + Double.parseDouble(lb1.getText());
                                exp.setText(equ);
                                res = temp - Double.parseDouble(lb1.getText());
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "x":
                                equ = equ + Double.parseDouble(lb1.getText());
                                exp.setText(equ);
                                res = temp * Double.parseDouble(lb1.getText());
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "/":
                                equ = equ + Double.parseDouble(lb1.getText());
                                exp.setText(equ);
                                res = temp / Double.parseDouble(lb1.getText());
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "<html>x<sup>n</sup></html>":
                                equ = equ + Double.parseDouble(lb1.getText()) + ")";
                                exp.setText(equ);
                                res = Math.pow(temp, Double.parseDouble(lb1.getText()));
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "<html>x<sup>1/n</sup></html>":
                                equ = equ + Double.parseDouble(lb1.getText()) + ")";
                                exp.setText(equ);
                                res = Math.pow(temp, 1 / Double.parseDouble(lb1.getText()));
                                lb1.setText("" + res);
                                op = "";
                                break;
                            case "mod":
                                equ = equ + Double.parseDouble(lb1.getText());
                                exp.setText(equ);
                                res = temp % Double.parseDouble(lb1.getText());
                                lb1.setText("" + res);
                                op = "";
                                break;
                        }
                    });
                } else if (c.equals("+") || c.equals("-") || c.equals("x") || c.equals("/")) {
                    b[i][j].addActionListener(e -> {
                        temp = Double.parseDouble(lb1.getText());
                        op = c;
                        equ = lb1.getText() + " " + op + " ";
                        exp.setText(equ);
                        lb1.setText("0");
                    });
                } else if (c.equals("C")) {
                    b[i][j].addActionListener(e -> {
                        exp.setText("");
                        lb1.setText("0");
                        res = 0;
                        equ = "";
                    });
                } else if (c.equals("CE")) {
                    b[i][j].addActionListener(e -> lb1.setText("0"));
                } else if (i == 0 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 != 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "cube(" + temp + ")";
                            exp.setText(equ);
                            res = temp * temp * temp;
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "sqr(" + temp + ")";
                            exp.setText(equ);
                            res = temp * temp;
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 0 && j == 1) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 == 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = "" + temp + "^(";
                            exp.setText(equ);
                            lb1.setText("0");
                            op = "<html>x<sup>n</sup></html>";
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = "" + temp + "^(1/";
                            exp.setText(equ);
                            lb1.setText("0");
                            op = "<html>x<sup>1/n</sup></html>";
                        }
                    });
                } else if (i == 0 && j == 2) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 == 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "sin(" + temp + ") ";
                            temp = temp * Math.PI / 180;
                            exp.setText(equ);
                            res = Math.sin(temp);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "<html>sin<sup>-1</sup>(" + temp + ")</html> ";
                            exp.setText(equ);
                            res = Math.asin(temp);
                            res = Math.atan(temp) * 180 / Math.PI;
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 0 && j == 3) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 == 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "cos(" + temp + ") ";
                            temp = temp * Math.PI / 180;
                            exp.setText(equ);
                            res = Math.cos(temp);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "<html>cos<sup>-1</sup>(" + temp + ")</html> ";
                            exp.setText(equ);
                            res = Math.acos(temp);
                            res = Math.atan(temp) * 180 / Math.PI;
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 0 && j == 4) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 == 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "tan(" + temp + ") ";
                            temp = temp * Math.PI / 180;
                            exp.setText(equ);
                            res = Math.tan(temp);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "<html>tan<sup>-1</sup>(" + temp + ")</html> ";
                            exp.setText(equ);
                            res = Math.atan(temp) * 180 / Math.PI;
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 1 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 != 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "cbrt(" + temp + ") ";
                            exp.setText(equ);
                            res = Math.cbrt(temp);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "sqrt(" + temp + ") ";
                            exp.setText(equ);
                            try {
                                res = Math.sqrt(temp);
                                lb1.setText("" + res);
                            } catch (Exception ex) {
                                lb1.setText("Invalid Input");
                            }
                        }
                    });
                } else if (i == 1 && j == 1) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 != 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "<html>e<sup>" + temp + "</sup></html>";
                            exp.setText(equ);
                            res = Math.exp(temp);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "<html>10<sup>" + temp + "</sup></html>";
                            exp.setText(equ);
                            res = Math.pow(10, temp);
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 1 && j == 2) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 != 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "ln(" + temp + ") ";
                            exp.setText(equ);
                            res = Math.log(temp);
                            lb1.setText("" + res);
                        } else {
                            if (op.equals("")) {
                                temp = Double.parseDouble(lb1.getText());
                                equ = equ + "log(" + temp + ") ";
                                exp.setText(equ);
                                res = Math.log10(temp);
                                lb1.setText("" + res);
                            } else {
                                temp = Double.parseDouble(lb1.getText());
                                equ = "log(" + temp + ") ";
                                exp.setText(equ);
                                res = Math.log10(temp);
                                lb1.setText("" + res);
                            }
                        }
                    });
                } else if (i == 1 && j == 3) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 == 0) {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "1/" + temp + " ";
                            exp.setText(equ);
                            res = Math.pow(temp, -1);
                            lb1.setText("" + res);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = equ + "abs(" + temp + ") ";
                            exp.setText(equ);
                            res = Math.abs(temp);
                            lb1.setText("" + res);
                        }
                    });
                } else if (i == 1 && j == 4) {
                    b[i][j].addActionListener(e -> {
                        if (shiftCount % 2 != 0) {
                            temp = Math.random();
                            equ = equ + "rand ";
                            lb1.setText("" + temp);
                            exp.setText(equ);
                        } else {
                            temp = Double.parseDouble(lb1.getText());
                            equ = "" + temp + " % ";
                            exp.setText(equ);
                            lb1.setText("0");
                            op = "mod";
                        }
                    });
                } else if (i == 2 && j == 3) {
                    b[i][j].addActionListener(e -> {
                        String lab = lb1.getText();
                        if (!lab.equals("0")) {
                            lb1.setText(lab.substring(0, lab.length() - 1));
                        }
                        if (lab.length() == 1) {
                            lb1.setText("0");
                        }
                    });
                } else if (i == 2 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        if (equ.equals("\u03c0")) {
                            equ = "\u03c0";
                            exp.setText(equ);
                            lb1.setText("" + Math.PI);
                        } else {
                            equ = equ + "\u03c0";
                            exp.setText(equ);
                            lb1.setText("" + Math.PI);
                        }
                    });
                } else if (i == 3 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        shiftCount++;
                        if (shiftCount % 2 != 0) {
                            b[3][0].setBackground(new Color(250, 250, 250));
                            b[0][0].setText("<html>x<sup>3</sup></html>");
                            b[0][1].setText("<html>x<sup>1/n</sup></html>");
                            b[0][2].setText("<html>sin<sup>-1</sup></html>");
                            b[0][3].setText("<html>cos<sup>-1</sup></html>");
                            b[0][4].setText("<html>tan<sup>-1</sup></html>");
                            b[1][0].setText("" + (char) 8731);
                            b[1][1].setText("<html>e<sup>x</sup></html>");
                            b[1][2].setText("ln");
                            b[1][3].setText("abs");
                            b[1][4].setText("rand");
                        } else {
                            b[3][0].setBackground(new Color(210, 210, 210));
                            b[0][0].setText("<html>x<sup>2</sup></html>");
                            b[0][1].setText("<html>x<sup>n</sup></html>");
                            b[0][2].setText("sin");
                            b[0][3].setText("cos");
                            b[0][4].setText("tan");
                            b[1][0].setText("\u221A");
                            b[1][1].setText("<html>10<sup>x</sup></html>");
                            b[1][2].setText("log");
                            b[1][3].setText("1/x");
                            b[1][4].setText("mod");
                        }

                    });
                } else if (i == 4 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        temp = Double.parseDouble(lb1.getText());
                        int fact = (int) temp;
                        res = 1;
                        equ = equ + "fact(" + temp + ") ";
                        for (int k = fact; k >= 2; k--)
                            res = res * k;
                        lb1.setText("" + res);
                    });
                } else if (i == 5 && j == 0) {
                    b[i][j].addActionListener(e -> {
                        temp = Double.parseDouble(lb1.getText());
                        res = (-1) * temp;
                        lb1.setText("" + res);
                    });
                } else if (i == 6 && j == 0 || i == 6 && j == 1) {
                    String s1 = b[i][j].getText();
                    b[i][j].addActionListener(e -> {
                        equ = equ + s1;
                        exp.setText(equ);
                    });
                } else if ((i >= 3 && i <= 5 && j >= 1 && j <= 3) || (i == 6 && j == 3) || (i == 6 && j == 2)) {
                    String s = b[i][j].getText();
                    b[i][j].addActionListener(e -> {
                        if (lb1.getText().equals("0")) {
                            lb1.setText(s);
                        } else {
                            lb1.setText(lb1.getText() + s);
                        }
                    });
                }
            }

        }
    }

    void labels() {
        lb2 = new JLabel("Scientific");
        lb2.setFont(new Font("Arial", Font.PLAIN, 25));
        lb2.setPreferredSize(new Dimension(375, 45));
        lb2.setLocation(20, 10);
        add(lb2);

        exp = new JLabel("", SwingConstants.RIGHT);
        exp.setFont(new Font("Arial", Font.PLAIN, 20));
        exp.setPreferredSize(new Dimension(375, 35));
        exp.setLocation(20, 70);
        add(exp);

        lb1 = new JLabel("0", SwingConstants.RIGHT);
        lb1.setFont(new Font("Arial", Font.BOLD, 35));
        lb1.setPreferredSize(new Dimension(375, 50));
        lb1.setLocation(20, 95);
        add(lb1);
    }
}
