import java.util.*;

class FracApp{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int playagain = 1;
        System.out.println("Enter time per question: ");
        int time = s.nextInt();
        System.out.println("\n\n========== RULES ==========\n\n");
        

        while(playagain==1){
            for(int i = 1; i <= 10; i++){
                QandA mcq = new QandA();
                System.out.println("Question No."+i);
                System.out.println(mcq.getQuestion());
                ArrayList<String> options = mcq.getChoices();
                System.out.println("1)"+options.get(0));
                System.out.println("2)"+options.get(1));
                System.out.println("3)"+options.get(2));
                System.out.println("4)"+options.get(3));
                int answer = s.nextInt();
                System.out.println(checkans(mcq, answer));
                System.out.println(mcq.getCorrectAnswer());
            }
        }
    }
    static int checkans(QandA mcq, int answer){
        int f = 0;
        String c_answer = mcq.getCorrectAnswer();
        ArrayList<String> options = mcq.getChoices();
        switch(answer){
            case 1:
            if(c_answer.equals(options.get(0))){
                f = 1;
            }
            break;
            case 2:
            if(c_answer.equals(options.get(1))){
                f = 1;
            }
            break;
            case 3:
            if(c_answer.equals(options.get(2))){
                f = 1;
            }
            break;
            case 4:
            if(c_answer.equals(options.get(3))){
                f = 1;
            }
            break;
            default:
            System.out.println("Invalid Option!");
        }
        return f;
    }
}