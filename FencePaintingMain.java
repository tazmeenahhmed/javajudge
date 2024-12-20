package fencepainting; 

import java.util.Scanner;
import java.lang.Math;

public class FencePaintingMain {
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		String fj = input.nextLine();
		String[] farmerjohn = fj.split(" ", 2);
		int fjStart = Integer.parseInt(farmerjohn[0]);
		int fjEnd = Integer.parseInt(farmerjohn[1]);
		
		
		String bessie = input.nextLine();
		String[] bessie2 = bessie.split(" ", 2);
		int bStart = Integer.parseInt(bessie2[0]);
		int bEnd = Integer.parseInt(bessie2[1]);
		
		
		int total = 0;
		if (fjEnd < bStart || fjStart > bEnd) {
			total = (fjEnd-fjStart) + (bEnd - bStart);
		} else {
			int totalMax = Math.max(Math.max(fjStart, fjEnd), Math.max(bStart,bEnd));
			int totalMin = Math.min(Math.min(fjStart, fjEnd), Math.min(bStart,bEnd));
			total = totalMax - totalMin;
		}
		
		System.out.println(total);
	}
}
