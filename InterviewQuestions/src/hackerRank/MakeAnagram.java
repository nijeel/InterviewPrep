package hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeAnagram {

	public static int numberNeeded(String first, String second) {
		int ret = 0;
		Map<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < first.length(); i++) {
			Character curr = first.charAt(i);
			if (charCount.get(curr) == null) {
				charCount.put(curr, 1);
			} else {
				Integer count = charCount.get(curr) + 1;
				charCount.put(curr, count);
			}
		}

		for (int i = 0; i < second.length(); i++) {
			Character curr = second.charAt(i);
			if (charCount.get(curr) == null) {
				ret++;
			} else {
				Integer count = charCount.get(curr) - 1;
				if (count == 0) {
					charCount.remove(curr);
				} else {
					charCount.put(curr, count);
				}
			}
		}
		for(Integer c : charCount.values()){
			ret +=c;
		}
		return ret;
	}
	// private Map<>

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
