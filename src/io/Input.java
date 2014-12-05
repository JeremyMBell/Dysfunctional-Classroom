package io;
import java.util.Scanner;
public class Input {
    private static Scanner scan = new Scanner(System.in);
    public static int receiveInput () {
        System.out.print("Who do you want to target? ");
        return scan.nextInt();
    }
    
}
