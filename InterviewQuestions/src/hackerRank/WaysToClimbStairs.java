package hackerRank;

import java.util.Scanner;

public class WaysToClimbStairs {
    public static int countWaysToClimb(int steps){
        if(steps == 0){
            return 1;
        }
        if(steps < 0){
            return 0;
        }
        int[] waysToClimb = new int[steps];
        waysToClimb[0] = 1;
        if(steps > 1){
            waysToClimb[1] = 2;
            
        }
        if(steps > 2){
             waysToClimb[2] = 4; 
        }
        
        for(int i = 3 ; i < steps ; i++ ){
            waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2] + waysToClimb[i-3];
        }
        return waysToClimb[steps-1];
       //return countWaysToClimb(steps -1) + countWaysToClimb(steps -2) + countWaysToClimb(steps -3);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(countWaysToClimb(n));
        }
    }

}
