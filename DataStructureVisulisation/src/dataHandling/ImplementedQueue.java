package dataHandling;

import dataStructures.*;

public class ImplementedQueue extends DataTable {

	public ImplementedQueue(int n) {
		
		super(n);
	}
	
	
	Queue<int[]> inputQueue = new Queue<int[]>();
	
	@Override
	public void addToStructure(int[] coords) {
		
		inputQueue.enQueue(coords);
		
	}

	@Override
	public int[] retrieveRecentCo_ords() {
	
		if(inputQueue.isQueueEmpty()) {
			
			int[] exitVector = {-1};
			
			return exitVector;
			
			
		} else {
			
			return inputQueue.deQueue();
			
		}
	}
	
	
	
	
	
	

}
