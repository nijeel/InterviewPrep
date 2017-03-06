package hackerRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMaiden {
//    int getLeftChild(int index){ return 2*index +1 ;}
//    int getRigthChild(int index){ return 2*index +2 ;}
//    int getParent(int index){return (index-1)/2;}
//    boolean hasParent(int index){int i =  getParent(index); return i >= 0;}
//    void swap(int index1, int index2){
//    	int temp = heap[index1];
//    	heap[index1] = heap[index2];
//    	heap[index2] = temp;
//    }
//    int size = 0;
//    int[] heap;
//    public void addInHeap(int element){
//    		heap[size] = element;
//    		size++;
//    		heapifyUp();
//    	
//    }
//    
//    void heapifyUp(){
//    	int lastIndex = size-1;
//    	while(hasParent(lastIndex) && getParent(lastIndex) <  lastIndex){
//    		int parentIndex = getParent(lastIndex);
//    		int leftIndex = getLeftChild(parentIndex);
//    		int rightIndex = getRigthChild(parentIndex);
//    		if(rightIndex < size && rightIndex <= lastIndex && heap[leftIndex] > heap[rightIndex] ){
//    			swap(leftIndex,rightIndex);
//    		}
//    		if(heap[parentIndex] > heap[leftIndex]){
//    			swap(parentIndex,leftIndex);
//    		}
//    		lastIndex = parentIndex;
//    	}
//    }
//    public BigDecimal getMaiden(){
//    	if(size % 2 == 0){
//    		BigDecimal sum = new BigDecimal(heap[(size/2)] + heap[(size/2)-1]);
//    		return sum.divide(new BigDecimal(2)).setScale(1, RoundingMode.UNNECESSARY);
//    	}else{
//    		return new BigDecimal((heap[size/2])).setScale(1, RoundingMode.UNNECESSARY);
//    	}
//    }
PriorityQueue<Integer> pQHigh = new PriorityQueue<>(100000); //Max Heap 
PriorityQueue<Integer> pQLow = new PriorityQueue<>(100000,new Comparator<Integer>() {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	};
	
});// min heap

public void insertValue(Integer value){
	if(pQLow.isEmpty()){
		pQLow.add(value);
	}else if(pQLow.size() > pQHigh.size()){
	if( value < pQLow.peek()){
		pQHigh.add(pQLow.poll());
		pQLow.add(value);
	}else{
		pQHigh.add(value);
	}
}else{
	if(value > pQHigh.peek()){
		pQLow.add(pQHigh.poll());
		pQHigh.add(value);
	}else{
		pQLow.add(value);
	}
}
}
public BigDecimal getMaiden(){
	int size = pQLow.size() + pQHigh.size();
	if(size %2 == 0){
		BigDecimal sum = new BigDecimal(pQLow.peek() + pQHigh.peek());
		
		return sum.divide(new BigDecimal(2)).setScale(1, RoundingMode.UNNECESSARY);
	}else{
		return new BigDecimal(pQLow.peek()).setScale(1, RoundingMode.UNNECESSARY);
	}
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        RunningMaiden r = new RunningMaiden();
        
        r.pQHigh = new PriorityQueue<>(n/2);
        r.pQHigh = new PriorityQueue<>(n/2 +1 );
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            r.insertValue(a[a_i]);
            System.out.println(r.getMaiden());
            
        }
       
        
    }
}
