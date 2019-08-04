package com.code.test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CandidateCode {
	public static void main(String[] args) {
		if (args.length>0) {
			/*System.out.println("--> TRY");
				// TODO Auto-generated method stub
				for (String string : args) {
					System.out.println("-->"+string);
				}*/
			List<Integer> pEnergy = new ArrayList<Integer>();
			List<Integer> vStrength = new ArrayList<Integer>();
			Integer testCount = Integer.parseInt(args[0]);
			String[] result = new String[testCount];
			int count = -1;
			int startIndex = 0;
			int testIndex = 0;
			for (int i = 1; i < args.length; i++) {
				if (count == -1) {
					count = Integer.parseInt(args[i]);
					startIndex = i + 1;
				} else {
					if (i < (startIndex + count)) {
						vStrength.add(Integer.parseInt(args[i]));
					} else if (i < (startIndex + (count * 2))) {
						pEnergy.add(Integer.parseInt(args[i]));
					}
					if (i == (startIndex + (count * 2) - 1)) {
						result[testIndex] = "WIN";
						//System.out.println("vStrength"+vStrength);
						//System.out.println("pEnergy"+pEnergy);
						Collections.sort(vStrength);
						Collections.sort(pEnergy);
						//System.out.println("vStrength"+vStrength);
						//System.out.println("pEnergy"+pEnergy);
						for (int j = 0; j < count; j++) {
							if (pEnergy.get(j) < vStrength.get(j))
								result[testIndex] = "LOSE";
						}
						vStrength.clear();
						pEnergy.clear();
						count = -1;
						testIndex++;
					}
				}
			}
			 PrintWriter out = new PrintWriter(System.out);
			for (String string : result) {
				System.out.println(string);
				out.println(string);
			} 
		}
	}


}
