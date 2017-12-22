import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int index;
        if (args.length != 0) {
            index = Integer.parseInt(args[0]);
        } else {
            System.out.println("Bitte geben Sie den Index des zu berechnenden Fibonacci-Wertes ein:");
            Scanner input1 = new Scanner(System.in);
            index = Integer.parseInt(input1.next());
        }
        FibonacciDynamisch.listeVorwerte();
        System.out.println("Fibonacci-Sequenz an Stelle '" + index + "': " + FibonacciDynamisch.berechneFuerIndex(index));
        FibonacciDynamisch.listeVorwerte();
        System.out.println("Fibonacci-Sequenz an Stelle '" + (index+5) + "': " + FibonacciDynamisch.berechneFuerIndex(index+5));
        FibonacciDynamisch.listeVorwerte();
    }
}
