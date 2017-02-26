package Personal;

import java.util.HashMap;
import java.util.Map;

public class Paranthesis {
	
	public Boolean checkValidParanthesis(String s){
		Boolean isValid = true;
		Map<Character, Character> bracketsMap = new HashMap<Character,Character>();
		bracketsMap.put('{', '}');
		bracketsMap.put('(', ')');
		bracketsMap.put('[', ']');
		bracketsMap.put('<', '>');
		
		
		
		
		return isValid;
	}

	public static void main(String[] args) {
		Paranthesis p = new Paranthesis();
		System.out.println(p.checkValidParanthesis("{([<>])}").toString());

	}

}
