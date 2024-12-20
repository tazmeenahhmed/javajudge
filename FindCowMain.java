package judgefindthecow;
import java.util.*;

public class FindCowMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String grass = input.nextLine();
		
		int bessie = 0;
		int frontLegs = 0;
		
		for (int i = 0; i < grass.length()-1; i++) {
			
			String currentStrand = grass.substring(i, i+1);
			String postStrand = grass.substring(i+1, i+2);
			
			
			if (currentStrand.equals("(") && postStrand.equals("(")) {
				frontLegs++;
			}
			
			if (currentStrand.equals(")") && postStrand.equals(")")) {
				bessie += frontLegs;
			}
			
		}
		
		System.out.println(bessie);

	}

}
