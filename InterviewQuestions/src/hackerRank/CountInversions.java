package hackerRank;

import java.util.Scanner;

public class CountInversions {

    public static long countInversions(int[] arr){
        //int[] temp = new  int[arr.length];
//        long swaps = 0;
//        boolean swapped = false;
//       do{
//           swapped = false;
//            int i = 0; 
//            int j = 1;
//            while(j<arr.length){
//            if(arr[i] > arr[j]){
//                swapped = true;
//                swaps++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//            i++;
//            j++;
//        }
//       }while(swapped);
//        return swaps;
    	int[] temp = arr.clone();
    	return countInversion(arr,temp,0,arr.length-1);
    	
    }
    
    public static long countInversion(int[] arr,int[] temp, int lo, int hi ){
    	if(lo >= hi){
    		return 0;
    	}
    	else{
    		long count = 0;
    		int mid = (lo+hi)/2;
    		count += countInversion(temp,arr,lo,mid);
    		count +=countInversion(temp,arr,mid+1,hi);
    		count += merge(arr,temp,lo,hi);
    		return count;
    	}
    	
    }
    
    public static long merge(int[] arr,int[] temp,int lo,int hi){
    	int leftEnd = (lo+hi)/2;
    	int leftStart = lo;
    	int rightStart = leftEnd +1;
    	int rightEnd = hi;
    	int index = lo;
    	long count = 0;
    	
    	while(leftStart <= leftEnd || rightStart <= rightEnd  ){
    		if(leftStart <= leftEnd){
    			arr[index++] = temp[leftStart++];
    		}else if(rightStart <= rightEnd){
    			arr[index++] = temp[rightStart++];
    		}else if(temp[leftStart] < temp[rightStart]){
    			arr[index++] = temp[leftStart++];
    		}else{
    			arr[index++] = temp[rightStart++];
    			count += leftEnd +1 - leftStart;
    		}
    	}
    	return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }
    
    
}
