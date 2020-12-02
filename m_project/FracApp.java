import java.util.*;

class FracApp{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int playagain = 1;
        int ulC, olC, ulW, olW;
        System.out.println("Enter time per question: ");
        int time = s.nextInt();
        System.out.println("\n\n========== RULES ==========\n\n");

        while (playagain == 1) {
            for (int i = 1; i <= 10; i++) {
                int timerflag = 0;
                Qtimer qtimer = new Qtimer();
                QandA mcq = new QandA();
                System.out.print("Q.No. " + i + " => ");
                System.out.println(mcq.getQuestion());
                qtimer.runTimer();
                ArrayList<String> options = mcq.getChoices();
                System.out.println("1)"+options.get(0));
                System.out.println("2)"+options.get(1));
                System.out.println("3)"+options.get(2));
                System.out.println("4)"+options.get(3));
                int answer = s.nextInt();
                if(qtimer.getsec()<=time){
                    timerflag = 1;
                }
                int ansflag = checkans(mcq, answer, options);
                qtimer.endtimer();
            }

            System.out.println("\n============================\n");
            printScore();
            System.out.println("\n============================\n");
            System.out.println("Do you want to play again?(y/n)");
            
            while (playagain == 1 || playagain == 0) {
                char playAgain = s.next().charAt(0);
                switch (playAgain) {
                case 'Y' :
                case 'y' :
                    playagain = 1;
                    break;
                case 'N' :
                case 'n' :
                    playagain = 0;
                    break;
                default : 
                    System.out.println("Invalid Option!");
                    playagain = 2;
                    
            }
        }
        }
    }

    static int checkans(QandA mcq, int answer, ArrayList<String> option){
        int f = 0;
        String c_answer = mcq.getCorrectAnswer();
        switch(answer){
            case 1:
            if(c_answer.equals(option.get(0))){
                f = 1;
            }
            break;
            case 2:
            if(c_answer.equals(option.get(1))){
                f = 1;
            }
            break;
            case 3:
            if(c_answer.equals(option.get(2))){
                f = 1;
            }
            break;
            case 4:
            if(c_answer.equals(option.get(3))){
                f = 1;
            }
            break;
            default:
            System.out.println("Invalid Option!");
        }
        return f;
    }

    static void printScore(){

    }
}