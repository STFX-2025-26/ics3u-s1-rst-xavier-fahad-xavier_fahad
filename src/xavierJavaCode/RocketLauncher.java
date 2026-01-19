package xavierJavaCode;
import java.util.Scanner;

public class RocketLauncher {

	public static void main(String[] args) {
		
		// Variables
		Scanner sc = new Scanner(System.in);
		int fuelAmount = -1;
		String[] planetsArray = {"Venus", "Earth","Mars", "Jupiter", "Neptune", "Ceres"};
		String planet = "";
		int thrust = 0;
		String[] rocketsArray = {"Space Shuttle", "Atlas V", "Space Launch System", "Starship", "Falcon heavy"};
		String rocket = "";
		double[] gravityArray = {8.87, 9.8, 3.71, 24.8, 11.2, 0.27};
		double gravity = 0.0;
		double rocketWeight = 0.0;
		int[] massArray = {2030000, 590000, 2610000, 4989516, 1420000};
		int mass = 0;
		int planetChoice = 0;
		int rocketChoice = 0;
		String next = "";
		boolean fuelLevel = false;
		String choice = "";
		
		// Planet Selection
		System.out.println("Which planet would you like?");
		
		for (int i=0; i<planetsArray.length; i++) {
		System.out.println(i+1 + ": " + planetsArray[i]);
		}
		
		while ( planetChoice <= 0 || planetChoice > 6) {
			
			
			choice = sc.next();
			try {
				planetChoice = Integer.parseInt(choice);
			}
			catch (Exception e) {
				System.out.println("Enter an Integer");
			}	
		
			if (planetChoice <= -1) {
				System.out.println("Invalid Entry");
			}
			if (planetChoice > 6) {
				System.out.println("Invalid Entry");
			}
		}
		
		planetChoice = planetChoice - 1;
		planet =  planetsArray[planetChoice];
		System.out.println("You chose: " + planet);
		
		gravity = gravityArray[planetChoice];
		System.out.println("The gravity on " + planet + " is " + gravity + "m/s");
		
		// Rocket selection
		System.out.println("");
		System.out.println("(Press any Key then Enter to Continue)");
		next = sc.next();
		
		System.out.println("Select your Rocket");
		
		for (int i=0; i<rocketsArray.length; i++) {
		System.out.println(i+1 + ": " + rocketsArray[i]);
		}
		
		while ( rocketChoice <= 0 || rocketChoice > 5) {
			
			choice = sc.next();
			try {
				rocketChoice = Integer.parseInt(choice);
			}
			catch (Exception e) {
				System.out.println("Enter an Integer");
			}	
		
			if (rocketChoice <= 0) {
				System.out.println("Invalid Entry");
			}
			if (rocketChoice > 5) {
				System.out.println("Invalid Entry");
			}
		}
		
		rocketChoice = rocketChoice - 1;
		rocket =  rocketsArray[rocketChoice];
		System.out.println("You chose: " + rocket);
		
		mass = massArray[rocketChoice];
		rocketWeight = mass * gravity;
		System.out.println("The mass of the rocket is " + mass + "kg");
		
		
		// Fuel
		System.out.println("");
		System.out.println("(Press any Key then Enter to Continue)");
		next = sc.next();
		

		System.out.println("How much fuel(kg) would you like to enter?");
		
		choice = sc.next();
		try {
			fuelAmount = Integer.parseInt(choice);
		}
		catch (Exception e) {
			System.out.println("Invalid entry");
		}
		
		// Thrust
		System.out.println("");
		System.out.println("(Press any Key then Enter to Continue)");
		next = sc.next();
		
		System.out.println("How much thrust(N)?");
		thrust = sc.nextInt();
		
		// Does rocket have fuel
		if (fuelAmount <= 0) {
			System.out.println("Your Rocket doesn't have any fuel");
			System.out.println("Launch failed");
			System.exit(0);
		}
		else if (fuelAmount > 0) {
			System.out.println("Has fuel.");
		}
		
		// Thrust amount
		if (thrust <= rocketWeight) {
			System.out.println("Cannot carry mass of rocket(Not enough thrust)");
			System.out.println("Launch failed");	
			System.exit(0);
		}
		else if(thrust > rocketWeight) {
			System.out.println("Has enough thrust to lift rocket");
		}
		
		// Fuel levels
		fuelLevel = fuelLevel(fuelAmount, rocketWeight);
		
		if (fuelLevel = true) {
			System.out.println("Fuel is high");
			System.out.println("Launch was GREAT!");
		}
		
		if (fuelLevel = false) {
			System.out.println("Fuel is Low");
			System.out.println("Launch was short.");
		}
		
			
		// for memory management
		sc.close();

	}
	
	/*Description - determines if fuel is more or less than half the mass of the rocket
	 * Parameters - int fuel, int mass
	 * Return Type - boolean
	 */
	public static boolean fuelLevel(int fuel, double weight) {
		
		if (fuel > weight * 0.5) {
			return true;
		}
		
		if (fuel <= weight * 0.5) {
			return false;
		}
		else
			return false;
		
	}
	
	/*Description - determines output based on entered integer
	 * Parameters - int a
	 * Return type - int
	 */
	public static int planetSelection(int a) {
		
		if (a <= 0) {
			return -1;
		}
		
		if (a > 0 && a < 7) {
			return a;
		}
		if (a >= 7) {
			return -1;
		}
		else
			return -1;
		
	}

}
