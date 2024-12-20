package bovinegenomics;
import java.util.*;

public class BovineGenomicsMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String[] split = input.nextLine().split(" ", 2);
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		HashMap <Integer, String> genomics = new LinkedHashMap<>();
		
		for (int i = 1; i <= N; i++) {
			genomics.put(i, input.nextLine());
		}
		
		for (int i = N+1; i <= N+N; i++) {
			genomics.put(i, input.nextLine());
		}
		
		
		int position = 0;
		for (int i = 0; i < M; i++) {
			
			ArrayList<String> columnTemp = new ArrayList<>();
			for (int k = 1; k <= N+N; k++) {
				String dna = genomics.get(k);
				columnTemp.add(dna.substring(i, i+1));
			}
			
			
			Set<String> letterTemp = new LinkedHashSet<>();
			for (int x = 0; x < N; x++) {
				letterTemp.add(columnTemp.get(x));
			}
			
			
			Set<String> plainLetters = new LinkedHashSet<>();
			for (int y = N; y < N+N; y++) {
				plainLetters.add(columnTemp.get(y));
			}
			
			
			letterTemp.retainAll(plainLetters);
			if (letterTemp.isEmpty()) {
				position++;
			}
			
		}
		
		
		System.out.println(position);

	}

}
