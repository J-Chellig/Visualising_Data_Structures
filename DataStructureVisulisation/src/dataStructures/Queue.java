package dataStructures;

public class Queue<DataType> {
	
	private static class Node<DataType>{
		
		DataType value;
		
		Node<DataType> backwardsNeighbour;
		
		public Node(DataType value) {
			
			this.value = value;
			
		}
		
		
	}
	
	private Node<DataType> frontOfQueue;
	
	private Node<DataType> backOfQueue;
	
	
	public void enQueue(DataType value) {
		
		Node<DataType> wrapper = new Node<DataType>(value);
		
		if(frontOfQueue == null) {
			
			frontOfQueue = wrapper;
			backOfQueue = wrapper;
		} else {
			
			backOfQueue.backwardsNeighbour = wrapper;
			
			backOfQueue = wrapper;
			}
	
	}
	
	public DataType deQueue() throws IllegalStateException {
		
		if(frontOfQueue == null) {throw new IllegalStateException("Cannot pop an empty Queue!");}
		
		else {
			
			DataType outPutValue = frontOfQueue.value;
			
			if(frontOfQueue.backwardsNeighbour == null) {
				
				frontOfQueue = null;
				backOfQueue = null;
				
			} else {
				
				frontOfQueue = frontOfQueue.backwardsNeighbour;
				
				
			}
			
			return outPutValue;
		}
		
	}
	
	
	public boolean isQueueEmpty() {
		
		if(frontOfQueue == null) {return true;}
		
		else {return false;}
		
		
	}	
		
		
		
	
	
	
	
	

}
