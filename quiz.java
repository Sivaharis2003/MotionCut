import java.util.Scanner;

public class quiz 
   {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);


        String[] questions = {
            "  In which year java was introduced?",
            
            
            "  1-Megabyte = ?",
            
            
            "  If you need to copy the contents of MS Word, which command will you give??",
            
            
            "  A person who sends irrelevant or unsolicited messages by using Internet?",
            
            
            "  Which language is used for Android app development?",
            
            
            "  Who among the following had first invented microchip?",
            
            
            "  The ‘P’ in CPU stands for …?",
            
            
            "  Which among the following works faster?",
            
            
            "  One of the major works of software is to transform data into ……?",
            
            
            "  The first internet service was set up in India in …?"
        };

        
        String[][] options =
        {
            {"A. 1975", "B. 1985", "C. 1995", "D. 1997"},
            
            
            {"A. 1000", "B. 2000", "C. 1024", "D. 1214"},
            
            
            {"A.  Ctrl + X", "B. Ctrl + C", "C. Ctrl + V", "D. Ctrl + Z"},
            
            
            {"A. Programmer", "B. Hacker", "C. Spammer", "D. Hobbyist"},
            
            
            {"A. Swift", "B. Kotlin", "C. JavaScript", "D. Python"},
            
            
            {"A. Jack Kilby", "B. Jack Dorsey", "C. Ronald Rider", "D. Greg Chesson"},
            
            
            {"A. Plan", "B. Performance", "C. Program", "D. Process"},
            
            
            {"A. RAM", "B. ROM", "C. Cache", "D. Register"},
            
            
            {"A. Video", "B. Website", "C. Software program", "D. Information"},
            
            
            {"A. 1995", "B. 1998", "C. 2000", "D. 1993"}
            
        };

        
        char[] answers = {'C', 'C', 'B', 'C', 'B', 'A', 'D', 'C', 'D', 'A'};

        
        int score = 0;

        
        for (int i = 0; i < questions.length; i++)
        {
            
            System.out.println((i + 1) + ". " + questions[i]);
            
            for (String option : options[i]) 
            {
                System.out.println(option);
            }

            
            System.out.print("Your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            
            if (userAnswer == answers[i])
            {
                
                System.out.println ("WOW! that's Correct :)\n");
                score++;
            } 
            else 
            {
                System.out.println("Wrong! GOOD TRY >> The correct answer is " + answers[i] + ".\n");
            }
        }

        
        System.out.println("THAT'S GREAT You scored " + score + " out of " + questions.length);

        
        scanner.close();
    }
}
