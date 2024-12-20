package promotioncounting;

import java.util.Scanner;

public class PromotionCountingMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// input
		String bronze = input.nextLine();
		String[] bronzeInOut = bronze.split(" ", 2);
		int bronzeRegBefore = Integer.parseInt(bronzeInOut[0]);
		int bronzeRegAfter = Integer.parseInt(bronzeInOut[1]);
		
		String silver = input.nextLine();
		String[] silverInOut = silver.split(" ", 2);
		int silverRegBefore = Integer.parseInt(silverInOut[0]);
		int silverRegAfter = Integer.parseInt(silverInOut[1]);
		
		String gold = input.nextLine();
		String[] goldInOut = gold.split(" ", 2);
		int goldRegBefore = Integer.parseInt(goldInOut[0]);
		int goldRegAfter = Integer.parseInt(goldInOut[1]);
		
		String platinum = input.nextLine();
		String[] platinumInOut = platinum.split(" ", 2);
		int platinumRegBefore = Integer.parseInt(platinumInOut[0]);
		int platinumRegAfter = Integer.parseInt(platinumInOut[1]);
		
		// method
		int bronzeToSilver = 0;
		int silverToGold = 0;
		int goldToPlatinum = 0;
		
		goldToPlatinum = Math.abs(platinumRegBefore - platinumRegAfter);
		silverToGold = Math.abs(goldToPlatinum - (goldRegBefore - goldRegAfter));
		bronzeToSilver = Math.abs(silverToGold - (silverRegBefore - silverRegAfter));
		
		// output
		System.out.println(bronzeToSilver);
		System.out.println(silverToGold);
		System.out.println(goldToPlatinum);
		
		
		

	}

}
