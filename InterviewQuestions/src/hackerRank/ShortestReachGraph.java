package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReachGraph {
    public static class Graph {
        HashMap<Integer,Node> nodeMap = new HashMap<Integer,Node>();
        public class Node{
        	int id;
        	List<Node> adjacent;
        	
        }
        public Graph(int size) {
            for(int i = 0 ; i< size; i++){
            	Node n = new Node();
            	n.id = i;
            	nodeMap.put(n.id, n);
            }
        }

        public void addEdge(int first, int second) {
            Node n1 = nodeMap.get(first);
            Node n2 = nodeMap.get(second);
            if(n1.adjacent == null){
            	n1.adjacent = new ArrayList<>();
            }
            if(n2.adjacent == null){
            	n2.adjacent = new ArrayList<>();
            }
            n1.adjacent.add(n2);
            n2.adjacent.add(n1);
        }
        
        public int[] shortestReach(int startId) {
        	Node source = nodeMap.get(startId);
        	int[] pathLengthById = new int[nodeMap.size()];
        	Arrays.fill(pathLengthById, -1);
        	   HashSet<Integer> visited = new HashSet<Integer>();
        	  LinkedList<Node> nextToVisit = new LinkedList<Node>();
        	  nextToVisit.add(source);
        	  while(!nextToVisit.isEmpty()){
        		  Node current = nextToVisit.remove();
        		  
        		  if(visited.contains(current.id)){
        			  continue;
        		  }
        		  if(current.id == source.id){
        			  pathLengthById[current.id] =  0;
        		  }
        		  visited.add(current.id);
        		  if(current.adjacent != null ){
        			  Integer childLength = pathLengthById[current.id] + 6;
        			  for(Node child: current.adjacent){
        				  if(!visited.contains(child.id)){
        			    		
        				  nextToVisit.add(child);
        				  pathLengthById[child.id] =  (pathLengthById[child.id] <  0 || pathLengthById[child.id] > childLength ) ? childLength : pathLengthById[child.id] ;
        				  }
        			  }
        			}
        		  
        	  }
        	  
        	   
        	   return pathLengthById;
           }
        
       
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
