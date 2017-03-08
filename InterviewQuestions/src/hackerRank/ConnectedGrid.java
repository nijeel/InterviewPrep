package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectedGrid {
    
    
    public static int getBiggestRegion(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length ; i++){
        	Arrays.fill(visited[i], 0);
        }
        int largestRegion = 0;
        int i =0, j=0;
        while(i < matrix.length && j < matrix[0].length ){
        	if(matrix[i][j] == 0 && visited[i][j] == 0){
        	visited[i][j] = 1;
            j++;
            if(j > matrix[0].length){
                j = 0; 
                i++;
            }
          }else{
        	int currRegion = getRegionSize(matrix,i,j,visited);
        	largestRegion = largestRegion < currRegion ? currRegion : largestRegion;
        	 j++;
             if(j > matrix[0].length){
                 j = 0; 
                 i++;
             }
          }
        }
        return largestRegion;
        
    }
    
    static int  getRegionSize(int[][] matrix, int row , int column, int[][] visited){
    	
    	if(isOutOfBonds(matrix, row, column)){
    		return 0;
    	}
		
    	if( notVisitedAndMarked(matrix,row,column,visited)){
    		int count = 1;
    		visited[row][column] = 1;
    		if(notVisitedAndMarked(matrix,row+1,column+1,visited)){ //diagonal down right
    			count +=  getRegionSize(matrix,row+1,column+1,visited);
    		}
    		if(notVisitedAndMarked(matrix,row+1,column,visited)){ //down
    			count += getRegionSize(matrix,row+1,column,visited);
    		}
    		if(notVisitedAndMarked(matrix,row,column+1,visited)){ //right
    			count += getRegionSize(matrix,row,column+1,visited);
    		}
    		if(notVisitedAndMarked(matrix,row,column-1,visited)){ //left
    			count += getRegionSize(matrix,row,column-1,visited);
    		}
    		if(notVisitedAndMarked(matrix,row-1,column,visited)){ //up
    			count += getRegionSize(matrix,row-1,column,visited);
    		}
    		if(notVisitedAndMarked(matrix,row-1,column-1,visited)){ //diagonal up left
    			count += getRegionSize(matrix,row-1,column-1,visited);
    		}
    		if(notVisitedAndMarked(matrix,row-1,column+1,visited)){ //diagonal up right
    			count += getRegionSize(matrix,row-1,column+1,visited);
    		}
    		if(notVisitedAndMarked(matrix,row+1,column-1,visited)){ //diagonal down left
    			count += getRegionSize(matrix,row+1,column-1,visited);
    		}
    		return count;
    	}else{
    		return 0;
    	}
    }
    
    static boolean isOutOfBonds(int[][] matrix,int row, int column){
    	
    	if(row >= matrix.length || column >= matrix[0].length || row < 0 || column < 0){
    		return true;
    	}else{
    		return false;
    	}
    }
    static boolean notVisitedAndMarked(int[][] matrix, int row , int column, int[][] visited){
    	if(isOutOfBonds(matrix, row, column)){
    		return false;
    	}
    	if(matrix[row][column] == 1  && visited[row][column] == 0){
    		return true;
    	}else{
    		return false;
    	}
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
