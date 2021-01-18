package dataHandling;

import dataStructures.LinkedList;


public class RandomLinkedListSorting extends DataTable {

	public RandomLinkedListSorting(int n) {
		super(n);
	}

	
	private LinkedList<int[]> co_Ordinates = new LinkedList<int[]>();
	
	
	@Override
	public void addToStructure(int[] coords) {
		
		co_Ordinates.addToList(coords);
		
	}

	@Override
	public int[] retrieveRecentCo_ords() {
		
		if(co_Ordinates.isListEmpty()) {
			
			int[] emptyVector = {-1};
			
			return emptyVector;
			
		}
		
		else {
			
			
			int randomIndex = (int) (Math.random()*co_Ordinates.getSizeOfList());
			
			return co_Ordinates.deleteNodeAtIndex(randomIndex);
			
		}
		
		
	}

	
	
	
	
	
}
