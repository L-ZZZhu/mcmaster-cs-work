import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	
	public static void main(String[] args) {
		game();
	}

	public static void game() {
		Scanner myScanner = new Scanner(System.in);
		Random gen = new Random();
		
		int r = gen.nextInt(999999) + 1;
		int guess;
		
		System.out.print("Guess a number between 1 and 1,000,000: ");
		guess = myScanner.nextInt();
		
		
		while(guess != r) {
			if(guess < r) {
				System.out.print("Sorry, that was incorrect. Please guess a higher number: ");
				guess = myScanner.nextInt();
			}
			else if(guess > r) {
				System.out.print("Sorry, that was incorrect. Please guess a lower number: ");
				guess = myScanner.nextInt();
			}
		}
		
			
		System.out.println("Congratualtions! The number was " + guess + "!");
		myScanner.close();
	}
	
}
