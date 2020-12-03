
import java.util.*;

class FracApp{
    static int underLimitCorrect, overLimitCorrect,underLimitWrong, overLimitWrong;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int playagain = 1;
        System.out.println("\n\n========== RULES ==========\n\n");
        System.out.println("1) Read the question carefully and type the option number below the options.");
        System.out.println("2) Choosing invalid option will be considered as WRONG answer.");
        System.out.println("3) You can enter time for each question at the start.");
        System.out.println("4) Scoring System:");
        System.out.println("     POINTS AWARDED FOR EACH QUESTION: ");
        System.out.println("                       Under Time-Limit \t\t Over Time-Limit");
        System.out.println("Correct Answers:\t\t10\t\t\t\t6");
        System.out.println("Wrong Answers:  \t\t3\t\t\t\t0");
        System.out.println("5) Score-sheet will be displayed at the end of each session.\n\n");

        System.out.println("Enter time per question: ");
        int time = s.nextInt();

        while (playagain == 1) {

            underLimitCorrect = 0;
            overLimitCorrect = 0;
            underLimitWrong = 0;
            overLimitWrong = 0;

            for (int i = 1; i <= 10; i++) {

                int timerflag = 0;
                Qtimer qtimer = new Qtimer();
                QandA mcq = new QandA();
                qtimer.runTimer();
                if(i != 1 ) {
                    System.out.println();
                }
                System.out.print("\nQ.No. " + i + " => ");
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
            System.out.println("\n============================");
            System.out.print("Do you want to play again (y/n) ? ");
            
            char playAgain = s.next().charAt(0);
            while (playAgain != 'y' && playAgain != 'n') {
                System.out.print("Invalid Entry! \n Enter ( y/n ) :"); 
                playAgain = s.next().charAt(0);
            } 
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
                    break; 
            }
        
        }
        s.close();
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
        System.out.println("Correct Answers:\t\t"+underLimitCorrect+"\t\t\t\t"+overLimitCorrect);
        System.out.println("Wrong Answers:  \t\t"+underLimitWrong+"\t\t\t\t"+overLimitWrong);
        System.out.println("\nTOTAL POINTS: "+(underLimitCorrect*10+overLimitCorrect*6+underLimitWrong*3+overLimitWrong*0)+"  ("+underLimitCorrect*10+"+"+overLimitCorrect*6+"+"+underLimitWrong*3+"+"+overLimitWrong*0+")");
    }
    static void ans_state(int timerflag, int ansflag){
        switch(timerflag){
            case 0:
                if(ansflag == 1){
                    overLimitCorrect++;
                }else{
                    overLimitWrong++;
                }
                break;
            case 1:
                if(ansflag == 1){
                    underLimitCorrect++;
                }else{
                    underLimitWrong++;
                }
                break;
        }
    }
}