package dataHandling;

import dataStructures.BinaryTreeOfIntArray;

public class BinaryTreeSmallestRetrival extends DataTable {
	
	public BinaryTreeSmallestRetrival(int n) 
	{
		
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
			
			int[] exitVector = {-1};
			
			return exitVector;
			
		} else {
			
			
			return co_Ordinates.pushSmallestValue();
			
		}
		
	}
	
	
	
	
	

}
