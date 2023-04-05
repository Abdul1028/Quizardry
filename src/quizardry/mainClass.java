/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizardry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author AbdulRasool
 */
public class mainClass extends JFrame implements ActionListener {

    public static int count = 0;
    public static int ans_selected = 0;
    public static int score = 0;
    public static int timer = 20;

    ButtonGroup group;
    String name;
    String username;
    JLabel qno, welcome;
    JTextArea question;
    JButton next, submit, lifeline;
    JRadioButton opt1, opt2, opt3, opt4;

    String questions[][] = new String[10][5];
    String useranswer[][] = new String[10][1];
    String answers[][] = new String[10][2];

    mainClass(String name, String username) {

        questions[0][0] = "Which is used to find and fix "
                + "bugs in the Java programs.?"
                + "";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        this.name = name;
        this.username = username;
        setSize(540, 400);
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        qno = new JLabel();
        qno.setText("");
        qno.setBounds(135, 50, 50, 60);
        qno.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        qno.setForeground(Color.WHITE);

        question = new JTextArea();
        question.setText("");
        question.setBounds(160, 90, 280, 50);
        question.setFont(new Font("TimesNewRoman", Font.BOLD, 17));
        question.setBackground(new java.awt.Color(0, 0, 0, 0));
        question.setForeground(Color.WHITE);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setEditable(false);
        question.setBorder(null);

        add(qno);
        add(question);

        welcome = new JLabel("Welcome, " + name);
        welcome.setBounds(20, 10, 400, 30);
        welcome.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        welcome.setBackground(new java.awt.Color(0, 0, 0, 0));
        welcome.setForeground(Color.WHITE);

        add(welcome);

        next = new JButton("Next");
        next.setBounds(90, 310, 100, 30);        //x,y,width,height
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new java.awt.Color(0, 0, 0, 0));
        next.setOpaque(false);
        next.setForeground(Color.WHITE);
        next.setBorder(BorderFactory.createBevelBorder(1, Color.pink, Color.cyan));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(200, 310, 100, 30);        //x,y,width,height
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new java.awt.Color(0, 0, 0, 0));
        submit.setForeground(Color.WHITE);
        submit.setBorder(BorderFactory.createBevelBorder(1, Color.cyan, Color.pink));
        submit.setOpaque(false);
        submit.addActionListener(this);
        submit.setEnabled(false);
        submit.setForeground(Color.decode("#9D9FA2"));
        add(submit);

        lifeline = new JButton("Lifeline");
        lifeline.setBounds(310, 310, 100, 30);        //x,y,width,height
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new java.awt.Color(0, 0, 0, 0));
        lifeline.setForeground(Color.WHITE);
        lifeline.setBorder(BorderFactory.createBevelBorder(1, Color.pink, Color.cyan));
        lifeline.addActionListener(this);
        lifeline.setOpaque(false);
        add(lifeline);

        opt1 = new JRadioButton("");
        opt1.setForeground(Color.WHITE);
        opt1.setBounds(50, 195, 200, 25);
        opt1.setBackground(new java.awt.Color(0, 0, 0, 0));
        opt1.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        opt1.setOpaque(false);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setForeground(Color.WHITE);
        opt2.setBounds(280, 195, 200, 25);
        opt2.setBackground(new java.awt.Color(0, 0, 0, 0));
        opt2.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        opt2.setOpaque(false);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setForeground(Color.WHITE);
        opt3.setBounds(50, 260, 200, 25);
        opt3.setBackground(new java.awt.Color(0, 0, 0, 0));
        opt3.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        opt3.setOpaque(false);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setForeground(Color.WHITE);
        opt4.setBounds(280, 260, 200, 25);
        opt4.setBackground(new java.awt.Color(0, 0, 0, 0));
        opt4.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        opt4.setOpaque(false);
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/quizardry/mainquizbg.jpg"));

        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 540, 360);
        add(image);

        start(count);

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ")");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public static void main(String args[]) {
        new mainClass("User", "User");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left : " + timer + " seconds"; // 15
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 17));

        if (timer == 0) {
            g.setColor(Color.RED);
            g.drawString("TIMES UP!!!", 330, 65);
        } else if (timer < 5) {
            g.setColor(Color.RED);
            g.drawString(time, 330, 65);
        } else {
            g.setColor(Color.GREEN);
            g.drawString(time, 330, 65);
        }

        if (ans_selected == 1) {
            timer = 20;
            ans_selected = 0;

        }

        if (ans_selected == 0 && timer == 0) {
            useranswer[count][0] = "Not given";
            timer = 20;
            count++;
            start(count);
        }

        if (count == 10) {
            setVisible(false);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            //repaint();
            opt1.setEnabled(true);
            opt1.setForeground(Color.decode("#FFFFFF"));
            opt2.setEnabled(true);
            opt2.setForeground(Color.decode("#FFFFFF"));
            opt3.setEnabled(true);
            opt3.setForeground(Color.decode("#FFFFFF"));
            opt4.setEnabled(true);
            opt4.setForeground(Color.decode("#FFFFFF"));
            ans_selected = 1;
            if (group.getSelection() == null) {
                useranswer[count][0] = "wronganswer";
            } else {
                useranswer[count][0] = group.getSelection().getActionCommand();
            }

            if (count == 8) {
                submit.setEnabled(true);
                submit.setForeground(Color.decode("#FFFFFF"));
                next.setEnabled(false);
                next.setForeground(Color.decode("#9D9FA2"));
            }

            count++;
            start(count);
        } else if (e.getSource() == submit) {
            ans_selected = 1;
            if (group.getSelection() == null) {
                useranswer[count][0] = "wronganswer";
            } else {
                useranswer[count][0] = group.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswer.length; i++) {
                for (int j = 0; j < useranswer[i].length; j++) {
                    System.out.println(useranswer[i][j]);
                }

            }

            for (int i = 0; i < useranswer.length; i++) {
                if (useranswer[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
                System.out.println("Score is: " + score);
                System.out.println(Arrays.toString(answers));
            }

            try {
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3307/quiz";
                String user = "root";
                String pass = "root";
                con = DriverManager.getConnection(url, user, pass);

                String query = "INSERT INTO SCORE VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                login s = new login();

                String g = s.loguser.getText();

                pst.setString(1, g);
                pst.setString(2, name);
                pst.setInt(3, score);
                pst.execute();

                JOptionPane.showMessageDialog(this, "Your answers submitted Thanks for playing Quizardry");

            } catch (Exception except) {
                except.printStackTrace();
            }

        } else if (e.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt2.setForeground(Color.decode("#9D9FA2"));
                opt3.setEnabled(false);
                opt3.setForeground(Color.decode("#9D9FA2"));
            } else {
                opt1.setEnabled(false);
                opt1.setForeground(Color.decode("#9D9FA2"));
                opt4.setEnabled(false);
                opt4.setForeground(Color.decode("#9D9FA2"));
            }
            lifeline.setEnabled(false);
            lifeline.setForeground(Color.decode("#9D9FA2"));
        }
    }

}
