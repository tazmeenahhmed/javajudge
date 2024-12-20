package judgefencerepair;
import java.util.*;

public class FenceRepairMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		long numPlanks = input.nextLong();
		input.nextLine();
		PriorityQueue<Long> cutsNeeded = new PriorityQueue<>();
		
		for (long i = 0; i < numPlanks; i++) {
			cutsNeeded.offer(input.nextLong());
		}
		
		long total = 0;
		while (cutsNeeded.size() > 1) {
			
			long lowOne = cutsNeeded.poll();
			long lowTwo = cutsNeeded.poll();
			cutsNeeded.offer(lowOne+lowTwo);
			total += lowOne+lowTwo;
			
		}
		
		System.out.println(total);

	}

}
