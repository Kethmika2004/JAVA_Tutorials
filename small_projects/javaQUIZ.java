import java.util.Scanner;

public class javaQUIZ {
    public static void main(String[] args){

        //Questions;
        String[] questions = {"Who is known as the Father of Computer?",
                              "What does CPU stand for?",
                              "Which programming language is known as the language of the web?",
                              "What year was Facebook launched?",
                              "What was the first progamming language?"};

        //Options
        String[][] options = {{"01) Charles Babbage", "02) Alan Turing", "03) John von Neumann", "04) Thomas Edison"}, 
                              {"01) Central Process Unit", "02) Computer Personal Unit", "03) Central Processing Unit", "04) Central Processor Unit"}, 
                              {"01) Python", "02) Java", "03) C++", "04) JavaScript"}, 
                              {"01) 2004", "02) 2005", "03) 2006", "04) 2003"}, 
                              {"01) Fortran", "02) COBOL", "03) Assembly Language", "04) Ada"}};
        
        //Answers
        int[] answers = {1, 3, 4, 1, 1};

        int score = 0;
        int guess ;

        Scanner scanner = new Scanner(System.in);

        //Welcome message
        System.out.println("*************************************");
        System.out.println("***| WELCOME TO THE QUIZ PROGRAM |***");
        System.out.println("*************************************");


        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Student ID number: ");
        String IDnum = scanner.nextLine();

        System.out.println();

        if(IDnum.charAt(0) == '2' && IDnum.charAt(1) == '4' && IDnum.length() == 7){

            for(int i = 0; i < questions.length; i++){
                System.out.println(questions[i]);
                System.out.println();

                for(String option : options[i]){
                    System.out.println(option);
                }

                System.out.println();
                System.out.print("Enter the correct answer's number: ");
                guess = scanner.nextInt();

                if(guess == answers[i]){
                    System.out.println("-----------------------");
                    System.out.println("Your Answer is CORRECT!");
                    System.out.println("-----------------------");

                    score++;
                }
                else{
                    System.out.println("-------------------------");
                    System.out.println("Your Answer is INCORRECT!");
                    System.out.println("-------------------------");
                }


            }
        
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Dear "+ name +",");
            System.out.println("Your Final Mark is: " + score+ " out of " + questions.length);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
        else{
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("You are not Eligible for the Quiz, " + name);
            System.out.println("PLease check your UoM IDnumber ");
        }

        
        
        scanner.close();
    }
    
}
