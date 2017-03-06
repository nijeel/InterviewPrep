package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	
    public static long makeChange(int[] coins, int money) {
    	//HackerRank Optimal 

//        long[] DP = new long[money + 1]; // O(N) space.
//        DP[0] = (long)1; 	// n == 0 case.
//        for(int i = 0 ; i < coins.length; i++) {
//            int coin = coins[i];
//            for(int j = coin; j < DP.length; j++) {
//            // The only tricky step.
//                DP[j] += DP[j - coin];
//            }
//        }       
//        return DP[money];
//      
    	//NIjeel Bad approach
//    	long count = 0;
//        
//    	if(money == 0){
//        	return 1;
//        }
//    	if(coins.length == 0){
//    		return 0;
//    	}
//    	
//    	//return 
//    	for(int i = 0; i < coins.length ; i++){
//        	if(coins[i] <= money){
//        		int newMoney = (money-coins[i]);
//        		if(newMoney >= coins[i] || newMoney == 0 ){
//        		
//        		count = count + makeChange(coins,newMoney);
//        		}
//        	}
//        }
//        
//       return count;
    	return count(coins,coins.length,money);
    }
    
    public static long count (int[] coins,int m, int money){
    	if(money == 0){
    		return 1;
    	}
    	if(money<0){
    		return 0;
    	}
    	if(m<=0 && money > 0){
    		return 0;
    	}
    	return count(coins,m-1,money) + count(coins,m,money-coins[m-1]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
