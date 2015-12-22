/**
 * 
 */
package TSP;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Huseen Sufi
 * Find the shortest route by visiting the nearest city until all cities are visited
 * implements a stack to keep track of current city and an ArrayList to keep track of the route
 */
public class findShortestRoute {
		//instance variables
		private int cost;
		private int numberofCities;
	    private Stack<Integer> myStack;
	    private ArrayList<Integer> route;
	 
	    /**
	     * Constructor
	     * constructs Stack and ArrayList
	     */
	    public findShortestRoute() {
	        myStack = new Stack<Integer>();
	        route = new ArrayList<Integer>();
	    }
	    
	    /**
	     * @param matrix
	     * @return array of routes
	     * use nearest neighbor algorithm
	     */
	    public ArrayList<Integer> solve(int matrix[][]){
	    	
	    	//init variables
	        numberofCities = matrix.length - 1;
	        int[] visited = new int[numberofCities + 1];
	        visited[0] = 1;
	        myStack.push(0);
	        route.add(0);
	        int current = 0;
	        int next = 0;
	        int i;
	        int min = 0;
	        boolean minFlag = false;
	        
	        //while the stack isn't empty
	        while (!myStack.isEmpty()) {
	        	min = Integer.MAX_VALUE; //update min
	            current = myStack.peek(); //set current value to top of stack
	            i = 0; //set i
	            
	            //while there are cities left to visit
	            while (i <= numberofCities){
	            	//if the current city isn't a diagonal entry or has been visited yet
	                if (matrix[current][i] > 1 && visited[i] == 0){
	                	//if the current cost is less than the minimum
	                    if (min > matrix[current][i]){
	                        min = matrix[current][i]; //set the new min
	                        next = i; //set next
	                        minFlag = true;
	                    } //end inner if
	                } //end outer if
	                i++; //increment, could also use a for loop
	            } //end  inner while

	            //if a minimum value is found
	            if (minFlag){
    	            cost+=min; //update min count
	                visited[next] = 1; //set as visited
	                myStack.push(next); //push to stack 
	                route.add(next); //add to route array 
	                minFlag = false; //find new min
	                continue; //go to next iteration
	            } //end if
	            myStack.pop(); //pop current value
	        } //end outer while
	        System.out.println("Path " + route);
	        System.out.println("\ncost " + cost);
			return route;
	    } //end method
	 
}