package xavierJavaCode;
import java.util.Scanner;

public class RocketLauncher {

	public static void main(String[] args) {
		
		// Variables
		Scanner sc = new Scanner(System.in);
		int altitude = 0;
		double fuelAmount = 0.0;
		String[] planetsArray = {"Venus", "Earth","Mars", "Jupiter", "Neptune", "Ceres"};
		int thrust = 0;
		String[] rocketsArray = {"Space Shuttle", "Atlas V", "Space Launch System", "Starship", "Falcon heavy"};
		double gravity = 0.0;
		int rocketweight = 0;
		int rocketMass = 0;
		int planetChoice = 0;
		
		// Planet Selection
		System.out.println("Which planet would you like?");
		
		for (int i=0; i<planetsArray.length; i++) {
		System.out.println(i+1 + planetsArray[i]);
		}
		
		planetChoice = sc.nextInt();
		System.out.println("You chose: " + planetsArray[planetChoice-1]);
		
		
		// for memory management
		sc.close();

	}

}
