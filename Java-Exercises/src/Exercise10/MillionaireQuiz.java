package Exercise10;
import java.util.Scanner;

public class MillionaireQuiz {
    private static final String[] QUESTIONS = {
            "What is the capital of France?",
            "Who painted the Mona Lisa?",
            "What is the largest planet in our solar system?",
            "Which country is home to the kangaroo?",
            "What is the chemical symbol for gold?",
            "How many colors are there in a rainbow?",
            "What is the national language of Japan?",
            "Who wrote the novel 'Pride and Prejudice'?",
            "What is the tallest mountain in the world?",
            "Which year was the first moon landing?"
    };

    private static final String[][] OPTIONS = {
            {"A. Paris", "B. Rome", "C. Berlin", "D. Madrid"},
            {"A. Leonardo da Vinci", "B. Vincent van Gogh", "C. Pablo Picasso", "D. Michelangelo"},
            {"A. Mars", "B. Jupiter", "C. Saturn", "D. Earth"},
            {"A. Australia", "B. Canada", "C. Brazil", "D. China"},
            {"A. Ag", "B. Au", "C. Hg", "D. Cu"},
            {"A. Five", "B. Six", "C. Seven", "D. Eight"},
            {"A. Japanese", "B. Mandarin", "C. English", "D. Russian"},
            {"A. Jane Austen", "B. Charlotte Bronte", "C. Emily Bronte", "D. Virginia Woolf"},
            {"A. Mount Everest", "B. K2", "C. Kangchenjunga", "D. Makalu"},
            {"A. 1969", "B. 1972", "C. 1961", "D. 1955"}
    };

    private static final int[] ANSWERS = {0, 0, 1, 0, 1, 2, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz Bee Game!");
        System.out.println("Answer the following questions:");

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(QUESTIONS[i]);
            for (int j = 0; j < OPTIONS[i].length; j++) {
                System.out.println(OPTIONS[i][j]);
            }

            System.out.print("Your answer (Enter A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(getOptionLetter(ANSWERS[i]))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + getOptionLetter(ANSWERS[i]));
            }
            
            
            
            char[] chars = userAnswer.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c : chars){
               if(Character.isDigit(c)){
                  sb.append(c);
               }
            }
            System.out.println(sb);

            
        }

        System.out.println("\nFinal Question: For One Million!");
        System.out.println("What is the symbol for the chemical element 'Oxygen'?");
        System.out.print("Your answer: ");
        String finalAnswer = scanner.nextLine().toUpperCase();

        if (finalAnswer.equals("O")) {
            System.out.println("Congratulations! You won One Million!");
            score++;
        } else {
            System.out.println("Sorry, that's incorrect. You did not win One Million.");
        }

        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + (QUESTIONS.length + 1));
    }

    private static String getOptionLetter(int index) {
        return Character.toString((char) ('A' + index));
    }
}
