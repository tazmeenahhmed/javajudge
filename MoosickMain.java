package moosick;
import java.util.*;

public class MoosickMain {
	
	public static ArrayList<Integer> findSeventhChord(ArrayList<Integer> list) {
		
		ArrayList<Integer> seventhChord = new ArrayList<Integer>();
		
		if (!list.isEmpty()) {
		int cStart = 2 + list.get(0);
		
		for (int i = cStart; i < list.size(); i++) {
			seventhChord.add(list.get(i));
			}
		}

		Collections.sort(seventhChord);
		
		return seventhChord;
	}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> farmerSong = new ArrayList<Integer>();
		
		while(true) {
			String note = input.nextLine();
			if (note.equals("")) {
				break;
			}
			farmerSong.add(Integer.parseInt(note));
		}

				
		ArrayList<Integer> seventhChord = findSeventhChord(farmerSong);
		int seventhCount = seventhChord.size();
		
		int count = 0;
		ArrayList<Integer> indexChords = new ArrayList<Integer>();
		

		
		for (int i = 1; i < farmerSong.size() - (2 * seventhCount) ; i++) {
	
			int var = farmerSong.get(i);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for (int j = i; j < i + seventhCount; j++) {
				temp.add(farmerSong.get(j));
			}
			
			Collections.sort(temp);
			
			if (temp.equals(seventhChord)) {
				count++;
				indexChords.add(i);
			}
			
			else { 
				for (int x = -87; x <= 87; x++) {
					ArrayList<Integer> transposedChord = new ArrayList<>();
					for (int note : seventhChord) {
						int y = note + x;
						if (y >= 1 && y <=88) {
							transposedChord.add(y);
						}
					}
					Collections.sort(transposedChord);
					if(temp.equals(transposedChord)) {
						count++;
						indexChords.add(i);
						break;
					}
				}
			}
		}
		
		System.out.println(count);
		for (int x : indexChords) {
			System.out.println(x);
		}
	}
}
