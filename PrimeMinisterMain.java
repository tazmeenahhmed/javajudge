package judgeprimeminister;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeMinisterMain {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer[]> data = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int beginAt = Integer.parseInt(st2.nextToken());
			int endAt = Integer.parseInt(st2.nextToken());
			Integer[] numbers = {beginAt, endAt};
		
			data.put(i, numbers);
		}
		
		
		ArrayList<Integer> ultCount = new ArrayList<>();
		ArrayList<Integer> primes = prime(10000);
		List<ArrayList<Integer>> edges = new ArrayList<>();
		for (int i = 0; i < primes.size(); i++) {
		    edges.add(new ArrayList<>());
		}
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 1; j < primes.size(); j++) {
				if (primes.get(j) != primes.get(i) && digitCheck(primes.get(i), primes.get(j))) {
					edges.get(i).add(primes.get(j));
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
	
			Integer[] array = data.get(i);
			int start = array[0];
			int end = array[1];
	
			Queue<Integer> queue = new LinkedList<>();
			HashMap<Integer, Integer> distance = new HashMap<>();
			HashMap<Integer,Integer> parent = new HashMap<>();
			parent.put(start,0);
			distance.put(start, 0);
			queue.add(start);
			while (!queue.isEmpty()) {
				int current = queue.poll();
				for (int neighbor : edges.get(primes.indexOf(current))) {
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, distance.get(current) + 1);
						parent.put(neighbor, current);
						queue.add(neighbor);
					}
				}
			}
			
			ArrayList<Integer> path = new ArrayList<>();
			int backtrack = end;
			while (backtrack != 0) {
				path.add(0, backtrack);
				backtrack = parent.get(backtrack);
			}
			
			ultCount.add(path.size() - 1);
			
		}
		
		for (int count : ultCount) {
			System.out.println(count);
		}
		
		
		
	}
	
	
	private static boolean digitCheck(int x, int y) {
		boolean check = false;
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			int first = x%10;
			int second = y%10;
			
			x /= 10;
			y /= 10;
			
			if (first != second) {
				count++;
			}
		}
		
		if (count == 1) {
			check = true;
		}
		
		return check;
	}
	
	private static ArrayList<Integer> prime(int n) {
		boolean prime[] = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			prime[i] = true;
		}
		
		for (int p = 2; p*p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p*p; i <= n; i+=p) {
					prime[i] = false;
				}
			}
		}
		
		ArrayList<Integer> truePrime = new ArrayList<>();
		for (int i = 1000; i <= n; i++) {
			if (prime[i] == true) {
				truePrime.add(i);
			}
		}
		return truePrime;
	}
	

}