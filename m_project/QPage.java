
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JButton;
import java.awt.*;

class Qpage {
    public static void main(String args[]) {
        // TimeUnit time = new TimeUnit.SECONDS();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame pg = new JFrame();
        int width = screenSize.width;
        int height = screenSize.height;
        pg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pg.setSize(width, height);
        pg.setResizable(false);
        pg.setTitle("Fraction Quiz");
        pg.setVisible(true);
        pg.setLayout(new GridLayout(4, 1, 30, 0));

        JLabel num = new JLabel();
        num.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        JPanel questionNo = new JPanel();
        questionNo.setBackground(Color.WHITE);
        questionNo.setPreferredSize(new DimensionUIResource(width / 5 , height / 10));;

        JLabel q = new JLabel();
        q.setFont(new Font("Helvetica Neue", Font.PLAIN, 69));
        JPanel question = new JPanel();
        question.setBackground(Color.WHITE);

        JPanel options = new JPanel();
        options.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 100));
        options.setBackground(Color.DARK_GRAY);
        JButton op1 = new JButton();
        // op1.setSize(width / 2, height / 10);
        op1.setPreferredSize(new DimensionUIResource(width / 10, height / 20));
        op1.setFocusable(false);
        JButton op2 = new JButton();
        op2.setPreferredSize(new DimensionUIResource(width / 10, height / 20));
        op2.setFocusable(false);
        JButton op3 = new JButton();
        op3.setPreferredSize(new DimensionUIResource(width / 10, height / 20));
        op3.setFocusable(false);
        JButton op4 = new JButton();
        op4.setPreferredSize(new DimensionUIResource(width / 10, height / 20));
        op4.setFocusable(false);

        JLabel timerem = new JLabel();
        timerem.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
        timerem.setForeground(Color.WHITE);
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 10; i++) {
            Questions q_ = new Questions();
            num.setText("Question No." + (i+1));
            q.setText(q_.getQuestion());
            question.add(q);
            questionNo.add(num);
            ArrayList<String> oplst = q_.getChoices();
            // oplst = q_.getChoices();
            op1.setText(oplst.get(0));
            op2.setText(oplst.get(1));
            op3.setText(oplst.get(2));
            op4.setText(oplst.get(3));

            options.add(op1);
            options.add(op2);
            options.add(op3);
            options.add(op4);

            
            pg.add(questionNo);
            pg.add(question);
            pg.add(options);
            pg.add(timePanel);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}