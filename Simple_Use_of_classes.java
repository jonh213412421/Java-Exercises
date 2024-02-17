import java.util.Scanner;

public class Simple_Use_of_classes {
    public static void greeting() { //class that scans input and writes "greetings" + person number
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Greetings, " + name );
    }
    public static void state() { //class that gets the answer to the question "are you ok?" and interacts with user
        Scanner scan = new Scanner(System.in);
        String state = scan.nextLine();
        //conditions and answers
        if ("fine".equals(state)) { 
            System.out.println("good to know!");
        }
        else if ("so so".equals(state)) {
            System.out.println("oh!! Come on, get better");
        }
        else if ("bad".equals(state)) {
            System.out.println("you should get help");
        }
        else {
            System.out.println("sorry, i can't comprehend your answer");
        }
    }
    public static void main(String args[]) { //main function, calls previous classes
        System.out.println("Hi, what's your name? ");
        greeting();
        System.out.println("are you ok? ");
        state();
    }
}
