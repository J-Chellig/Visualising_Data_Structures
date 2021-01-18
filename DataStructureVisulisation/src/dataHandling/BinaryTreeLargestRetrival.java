package dataHandling;

import dataStructures.BinaryTreeOfIntArray;

public class BinaryTreeLargestRetrival extends DataTable {

	public BinaryTreeLargestRetrival(int n) {
		
		super(n);
		
	}
	
	private BinaryTreeOfIntArray co_Ordinates = new BinaryTreeOfIntArray();
	
	
	
	
	@Override
	public void addToStructure(int[] coords) {
		
		co_Ordinates.addToTree(coords);
		
	}

	@Override
	public int[] retrieveRecentCo_ords() {
		
		if(co_Ordinates.isTreeEmpty()) {
			
			int[] endVector = {-1};
			
			return endVector;
			
		} else {
			
			return co_Ordinates.retrieveLargestValue();
			
		}
	}
	
	

}
