import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Page_Layout extends JFrame{

    JLabel num = new JLabel();
    JLabel q = new JLabel();
    JPanel question = new JPanel();
    JPanel options = new JPanel();
    JButton op1 = new JButton();
    JButton op2 = new JButton();
    JButton op3 = new JButton();
    JButton op4 = new JButton();

    Font f1 = new Font("Helvetica Neue",Font.BOLD,20);
    Font f2 = new Font("Helvetica Neue",Font.PLAIN,20);

    int qnum;
    String ques;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    String ansc;

    Page_Layout() {
        op1.setFocusable(false);
        op2.setFocusable(false);
        op3.setFocusable(false);
        op4.setFocusable(false);
        op1.setText(ans1);
        op2.setText(ans2);
        op3.setText(ans3);
        op4.setText(ans4);

        options.setLayout(new FlowLayout(FlowLayout.CENTER,60,40));
        options.setBackground(Color.DARK_GRAY);
        options.add(op1);
        options.add(op2);
        options.add(op3);
        options.add(op4);

        num.setText("Question No. "+this.qnum+" :");
        num.setFont(f1);

        q.setText(ques);
        q.setFont(f2);
        question.add(q);
        question.setBackground(Color.WHITE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setTitle("Fraction Quiz");
        this.setLayout(new GridLayout(4,1,30,0));
        this.add(num);
        this.add(question);
        this.add(options);
        this.setVisible(true);
    }
}
