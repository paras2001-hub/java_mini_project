import java.util.concurrent.TimeUnit;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

class Qpage {
    public static void main(String args[]){
        TimeUnit time = new TimeUnit.SECONDS();

        JFrame pg = new JFrame();
        pg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pg.setSize(600, 400);
        pg.setResizable(false);
        pg.setTitle("Fraction Quiz");
        pg.setVisible(true);
        pg.setLayout(new GridLayout(
             4,
             1,
             30,
             0
        ));

        JLabel num = new JLabel();
        num.setFont(new Font("Helvetica Neue",Font.BOLD,20));
        JPanel questionNo = new JPanel();
        questionNo.setBackground(Color.WHITE);
        questionNo.setBounds(0, 0, 600, 100);
        
        JLabel q = new JLabel();
        q.setFont(new Font("Helvetica Neue",Font.PLAIN,20));
        JPanel question = new JPanel(); 
        question.setBackground(Color.WHITE);

        JPanel options = new JPanel();
        options.setLayout(new FlowLayout(
              FlowLayout.CENTER,
              60,
              40
        ));
        options.setBackground(Color.DARK_GRAY);
        JButton op1 = new JButton();
        op1.setFocusable(false);
        JButton op2 = new JButton();
        op2.setFocusable(false);
        JButton op3 = new JButton();
        op3.setFocusable(false);
        JButton op4 = new JButton();
        op4.setFocusable(false);
        
        JLabel timerem = new JLabel();
        timerem.setFont(new Font("Helvetica Neue",Font.BOLD,17));
        timerem.setForeground(Color.WHITE);
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.DARK_GRAY);

        for(int i = 0 ; i<1 ; i++){
            num.setText("Question No. 1 :");
            q.setText(" 1/2 + 5/7 = ");
            question.add(q);
            questionNo.add(num);

            op1.setText("17/14");
            op2.setText("13/14");
            op3.setText("15/14");
            op4.setText("19/14");

            options.add(op1);
            options.add(op2);
            options.add(op3);
            options.add(op4);


            int t = 30;
            while(t != 0){
                timerem.setText("TIME REMAINING :"+t);
                timePanel.add(timerem);
                time.sleep(1);
                t--;
            }
            pg.add(questionNo);
            pg.add(question);
            pg.add(options);
            pg.add(timePanel);
        }
    }
}