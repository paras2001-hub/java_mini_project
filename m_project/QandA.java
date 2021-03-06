import java.util.ArrayList;
import java.util.Collections;

public class QandA {
    private String question;
    private ArrayList<String> choices = new ArrayList<String>();
    private String correctAnswer;
    private String operator;
    private int a, b, c, d;

    public String getQuestion() {

        int max = 10, min = 1;
        this.a = (int) (Math.random() * (max - min + 1) + min);
        this.b = (int) (Math.random() * (max - min + 1) + min);
        this.c = (int) (Math.random() * (max - min + 1) + min);
        this.d = (int) (Math.random() * (max - min + 1) + min);
        max = 4;
        min = 1;
        int num, deno;
        int randOperator = (int) (Math.random() * (max - min + 1) + min);

        switch (randOperator) {
            case 1:
                num = (b == d) ?  a + c : this.a * this.d + this.c * this.b;
                deno = (b == d) ? b : this.b * this.d;
                
                this.correctAnswer = (num == deno ? "1" : num + "/" + deno);
                this.operator = "+";
                break;

            case 2:
                num = b == d ? a - c : this.a * this.d - this.c * this.b;
                deno = b == d ? b : this.b * this.d;
                this.correctAnswer = num == 0 ? "0" : (num == deno ? "1" : num + "/" + deno);
                this.operator = "-";
                break;

            case 3:
                num = a * c;
                deno = b * d;
                this.correctAnswer = num == deno ? "1" : num + "/" + deno;
                this.operator = "*";
                break;

            case 4:
                num = a * d;
                deno = c * b;
                this.correctAnswer = num == deno ? "1" : num + "/" + deno;
                this.operator = "÷";
                break;
        }
        question = a + "/" + b + " " +  this.operator + " " + c + "/" + d;
        return question;
    }

    public ArrayList<String> getChoices() {
        
        choices.add(0, ((a * b + 1) + "/" + (b * c)));
        choices.add(1, ((a * c + 3) + "/" + (b * c + 2)));
        choices.add(2, ((a * d + 2) + "/" + (b * c + 3)));
        choices.add(3, correctAnswer);
        Collections.shuffle(choices);
        return this.choices;

    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

}
