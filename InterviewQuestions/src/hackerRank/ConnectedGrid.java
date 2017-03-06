package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectedGrid {
    
    
    public static int getBiggestRegion(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        Arrays.fill(matrix,0);
        int largestRegion = 0;
        int i =0, j=0;
        while(matrix[i][j] == 0 && visited[i][j] == 0){
        	visited[i][j] = 1;
            i++;
            if(i > matrix.length){
                i = 0; 
                j++;
            }
          }
        return largestRegion;
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

}
