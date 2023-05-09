import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        Main result = new Main();
        System.out.println("Input:");
        String expression = input.nextLine();
        String answer = result.calc(expression);


        System.out.println("Output:\n" + answer);
    }
}


