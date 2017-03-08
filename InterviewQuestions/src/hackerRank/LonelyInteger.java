package hackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class LonelyInteger {

    
    public static int lonelyInteger(int[] a) {
//        ArrayList<Integer>  visitedNumbers = new ArrayList();
//        for(int i = 0; i < a.length ; i++){
//        	if(visitedNumbers.contains(a[i])){
//        		visitedNumbers.remove(Integer.valueOf(a[i]));
//        	}else{
//        		visitedNumbers.add(Integer.valueOf(a[i]));
//        	}
//        }
//        int lonely = visitedNumbers.get(0) ; 
//        return lonely;
        
        int lonely = 0;
        for(int i = 0; i < a.length ; i++){
        	lonely = lonely ^ a[i];
        }
        return lonely;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
