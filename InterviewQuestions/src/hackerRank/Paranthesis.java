package hackerRank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Paranthesis {
    
    public static boolean isBalanced(String expression) {
        HashMap<Character, Character> brackets = new HashMap<Character,Character>();
       brackets.put('(', ')');
       brackets.put('[', ']');
       brackets.put('{', '}');
       Stack<Character> balanceStack = new Stack<Character>();
       for(int i = 0; i < expression.length() ;i++ ){
    	   Character curr = expression.charAt(i);
    	   if(brackets.keySet().contains(curr)){
    		   balanceStack.push(curr);
    	   }else if(brackets.values().contains(curr)){
    		   if( !balanceStack.isEmpty() &&  brackets.get(balanceStack.peek()) != null && curr == brackets.get(balanceStack.peek())){
    	    		
    			   balanceStack.pop();
    		   }else{
    			   return false;
    		   }
    	   }
       }
       if(balanceStack.isEmpty()){
    	   return true;
       }else{
    	   return false;
       }
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        /*
         * 
         * Test Data: 
5
}][}}(}][))]
[](){()}
()
({}([][]))[]()
{)[](}]}]}))}(())(

Expected: 
NO
YES
YES
YES
NO
         */
    }
}
