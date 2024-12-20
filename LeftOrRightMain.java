package judgeleftorright;
import java.util.*;

public class LeftOrRightMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] pointA = input.nextLine().split(" ", 2);
		int x1 = Integer.parseInt(pointA[0]);
		int y1 = Integer.parseInt(pointA[1]);
		
		String[] pointB = input.nextLine().split(" ", 2);
		int x2 = Integer.parseInt(pointB[0]);
		int y2 = Integer.parseInt(pointB[1]);
		
		String[] pointC = input.nextLine().split(" ", 2);
		int x3 = Integer.parseInt(pointC[0]);
		int y3 = Integer.parseInt(pointC[1]);
		
		System.out.println("Point A coordinates: (" + x1 + ", " + y1 + ")");
		System.out.println("Point B coordinates: (" + x2 + ", " + y2 + ")");
		System.out.println("Point C coordinates: (" + x3 + ", " + y3 + ")");
		
		double firstHalf = (x1*y2) + (x2*y3) + (x3*y1);
		double secondHalf = (x2*y1) + (x3*y2) + (x1*y3);
		double calculation = 0.5*(firstHalf-secondHalf);
		
		if (calculation > 0) {
			System.out.println("LEFT");
		} 
		
		if (calculation < 0) {
			System.out.println("RIGHT");
		}
		
		if (calculation == 0) {
			System.out.println("SAME");
		}

	}

}
