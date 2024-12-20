package recordkeeping;
import java.util.*;

public class RecordKeepingMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();
        String[] read = new String[N];
        read[0] = input.nextLine();
        
        for (int x = 1; x < N; x++) {
        	read[x] = input.nextLine();
        }
        
        Map<String, Integer> keepCount = new TreeMap<>();
        int highest = 1;
        
        for (int i = 0; i < read.length; i++) {
 
        	String[] cowGroup = read[i].split(" ", 3);
        	TreeSet<String> currentCowGroup = new TreeSet<>(Arrays.asList(cowGroup));
        	String combine = String.join(" ", currentCowGroup);
        	
        	if(!keepCount.containsKey(combine)){
        		keepCount.put(combine, 1);
        	} else {
        		int value = keepCount.get(combine);
        		value++;
        		keepCount.put(combine, value);
        		
        		if(value > highest) {
        			highest = value;
        		}
        		
        	}
        }

        System.out.println(highest);
        
	}

}
