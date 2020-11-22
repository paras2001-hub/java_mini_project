import java.util.ArrayList;

public class Questions {
   private String Question;
   private ArrayList<String> choices; 
   private String correctAnswer;
   private String operator;

   public String getQuestion() {
       int a,b,c,d;
       int max=20,min=1;
       a = (int)(Math.random() * (max - min + 1) + min);
       b = (int)(Math.random() * (max - min + 1) + min);
       c = (int)(Math.random() * (max - min + 1) + min);
       d = (int)(Math.random() * (max - min + 1) + min);
       max = 5;
       min = 1;
       int num,deno;
       int randOperator = (int)(Math.random() * (max - min + 1) + min);
       
       switch(randOperator){
           case 1:
           num = a*d + c*b;
           deno = b*d;
           this.correctAnswer = num +"/"+ deno;
           this.operator="+";
           break;

           case 2:
           num = a*d - c*b;
           deno = b*d;
           this.correctAnswer = num +"/"+ deno;
           this.operator="-";
           break;

           case 3:
           num = a*c;
           deno = b*d;
           this.correctAnswer = num +"/"+ deno;
           this.operator="*";
           break;

           case 4:
           num = a*d;
           deno = c*b;
           this.correctAnswer = num +"/"+ deno;
           this.operator="/";
           break;
       }
   }



}
