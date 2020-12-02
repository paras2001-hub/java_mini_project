import java.util.*;

class FracApp{
    static int ulC, olC,ulW, olW;
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int playagain = 1;
        System.out.println("Enter time per question: ");
        int time = s.nextInt();
        System.out.println("\n\n========== RULES ==========\n\n");

        while (playagain == 1) {

            ulC = 0;
            olC = 0;
            ulW = 0;
            olW = 0;

            for (int i = 1; i <= 10; i++) {

                int timerflag = 0;
                Qtimer qtimer = new Qtimer();
                QandA mcq = new QandA();
                qtimer.runTimer();

                System.out.print("Q.No. " + i + " => ");
                System.out.println(mcq.getQuestion());
                
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

                ans_state(timerflag, ansflag);
            }

            System.out.println("\n============================\n");
            printScore();
            System.out.println("\n============================\n");
            System.out.println("Do you want to play again?(y/n)");
            while (playagain == 2) {
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
        System.out.println("                       Under Time-Limit \t\t Over Time-Limit");
        System.out.println("Correct Answers:\t\t"+ulC+"\t\t\t\t"+olC);
        System.out.println("Wrong Answers:  \t\t"+ulW+"\t\t\t\t"+olW);
        System.out.println("\nTOTAL POINTS: "+(ulC*10+olC*6+ulW*3+olW*0)+"  ("+ulC*10+"+"+olC*6+"+"+ulW*3+"+"+olW*0+")");
    }
    static void ans_state(int timerflag, int ansflag){
        switch(timerflag){
            case 0:
                if(ansflag == 1){
                    olC++;
                }else{
                    olW++;
                }
                break;
            case 1:
                if(ansflag == 1){
                    ulC++;
                }else{
                    ulW++;
                }
                break;
        }
    }
}