import java.util.Scanner;

public class Basic_Variables_and_Array {
    public static void main(String[] args) {
        int x = 10; //variable 1 (int)
        double y = 123213124; //variable 2 (double)
        int[] array = new int[2];
        array[0] = x;
        array[1] = (int) y;
        for (int i = 0; i <= 1; i++) {
            System.out.println(array[i]); //print each value into a line
        }
        String text = "hello world"; //string variable
        System.out.println(text); //print string variable
        Scanner scan = new Scanner(System.in); //create scanner
        String name;
        System.out.println("type your name: \n");
        name = scan.nextLine(); //scans and assgn to variable
        System.out.println("hi, " + name + ", you're awesome"); //prints 'name' variable in a context
    }
}
