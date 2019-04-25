import java.util.Random; 
import java.util.Scanner; 
public class DiceRoll {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Welcome to craps! Let's play!"); 
		char cont = 'y';  
		while (cont == 'y') {
			
			System.out.println("Please enter the number of sides on the die: "); 
			int number = scan.nextInt();
			System.out.println("Roll the dice!: enter \"Roll\" "); 
			String answer = scan.next(); 
			
			while (!(answer.equalsIgnoreCase("Roll"))) {
				System.out.println("Error, I did not understand: try again: "); 
				answer = scan.next(); 
			}
			
			int roll1 = generateRandomDieRollRandGen(number); 
			int roll2 = generateRandomDieRollMathRandom(number); 
			evaluateResult(roll1, roll2, answer);
			
			System.out.println("Would you like to continue? (y/n)");
			cont = scan.next().toLowerCase().charAt(0);  
			if (cont == 'n') {
				System.out.println("Thank you for playing!"); 
			}
			
		}
		scan.close(); 
			

	}
	
	public static int generateRandomDieRollRandGen (int sides) {
		Random randGen = new Random(); //seed doesn't really matter. 
		int diceSides = 1 + randGen.nextInt(sides); 
		return diceSides; 
	}
	
	
	public static int generateRandomDieRollMathRandom (int sides) {
		double factor = Math.random(); 
		double rawProbability = sides * factor; 
		if (Math.ceil(rawProbability) - rawProbability >= 0.5) {
			rawProbability = Math.ceil(rawProbability); 
		} else {
			rawProbability = Math.floor(rawProbability); 
		}
		if (rawProbability < 0.5) {
			rawProbability = (double) sides; /* this is an equalizer, because 1-(sides - 1) have twice the probability as
			 0 or the highest number, and we don't want 0, so converting 0 to 6 will double 6's probability, and remove
			 0, making everything equal */
		}
		return (int) rawProbability; 
		
	}
	
	public static void evaluateResult(int roll1, int roll2, String answer)  {
		if (answer.equalsIgnoreCase("Roll")) {
			System.out.println(roll1);
			System.out.println(roll2); 
			if (roll1 == 1 && roll2 == 1) {
				System.out.println("You got snake eyes!"); 
			}
			if (roll1 == 6 && roll2 == 6) {
				System.out.println("You got box cars!"); 
			}
		}
	}
	

}
