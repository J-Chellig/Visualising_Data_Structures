package dataHandling;

import dataStructures.Stack;

public class StackDataSorting extends DataTable {
	
	public StackDataSorting(int n) {
		
		super(n);
		
	}
	
	private Stack<int[]> co_Ordinates = new Stack<int[]>();

	@Override
	public void addToStructure(int[] coords) {
	
		co_Ordinates.pushToHeap(coords);
		
	}

	@Override
	public int[] retrieveRecentCo_ords() {
	
		if(co_Ordinates.isStackEmpty() == true) {
			
			int[] endVector = {-1};
			
			return endVector;
			}
		
		
		return co_Ordinates.pop();}
	 
	
}


