package xavierJavaCode;
import java.util.Scanner;

public class RocketLauncher {

	public static void main(String[] args) {
		
		// Variables
		Scanner sc = new Scanner(System.in);
		int altitude = 0;
		double fuelAmount = 0.0;
		String[] planetsArray = {"Venus", "Earth","Mars", "Jupiter", "Neptune", "Ceres"};
		String planet = "";
		int thrust = 0;
		String[] rocketsArray = {"Space Shuttle", "Atlas V", "Space Launch System", "Starship", "Falcon heavy"};
		String rocket = "";
		double[] gravityArray = {8.87, 9.8, 3.71, 24.8, 11.2, 0.27};
		double gravity = 0.0;
		int[] rocketWeight = {2030000, 590000, 2610000, 4989516, 1420000};
		int rocketMass = 0;
		int planetChoice = 0;
		int rocketChoice = 0;
		String next = "";
		
		// Planet Selection
		System.out.println("Which planet would you like?");
		
		for (int i=0; i<planetsArray.length; i++) {
		System.out.println(i+1 + ": " + planetsArray[i]);
		}
		
		while ( planetChoice <= 0 || planetChoice > 6) {
			try {
				planetChoice = sc.nextInt();
			}
			catch (Exception e) {			
			}	
		
			if (planetChoice <= 0) {
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
		System.out.println("(Press any Key and Enter to Continue)");
		next = sc.next();
		
		System.out.println("Select your Rocket");
		
		for (int i=0; i<rocketsArray.length; i++) {
		System.out.println(i+1 + ": " + rocketsArray[i]);
		}
		
		while ( rocketChoice <= 0 || planetChoice > 5) {
			try {
				rocketChoice = sc.nextInt();
			}
			catch (Exception e) {			
			}	
		
			if (planetChoice <= 0) {
				System.out.println("Invalid Entry");
			}
			if (planetChoice > 5) {
				System.out.println("Invalid Entry");
			}
		}
		
		rocketChoice = rocketChoice - 1;
		rocket =  rocketsArray[rocketChoice];
		System.out.println("You chose: " + rocket);
		
		rocketMass = rocketWeight[rocketChoice];
		System.out.println("The mass of the rocket is " + rocketMass + "Kg");
		
		// for memory management
		sc.close();

	}

}
