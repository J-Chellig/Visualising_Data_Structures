package dataStructures;

public class Stack<DataType> {

	private static class Node<DataType>{
		
		DataType value;
		Node<DataType> successor;
		
		public Node(DataType value) {
			
			this.value = value;
			
		}
	}
	
	private Node<DataType> topOfHeap;
	
	public void pushToHeap(DataType input) {
		
		Node<DataType> outputnode = new Node<DataType>(input);
		
		if(topOfHeap == null) {
			
			this.topOfHeap = outputnode;
			
		}
		
		else {
			
			outputnode.successor = this.topOfHeap;
			
			topOfHeap = outputnode;
		}
		
		
	}
	
	public DataType pop() throws IllegalStateException {
		
		if(this.topOfHeap == null) {
			
			throw new IllegalStateException("You cannot pop an empty stack!");
			
		}
		
		DataType outputValue = topOfHeap.value;
		
		topOfHeap = topOfHeap.successor;
		
		return outputValue;
	}
	
	
	
	public boolean isStackEmpty() {
		
		if(this.topOfHeap == null) {return true;}
		
		else { return false;}
		
		
	}
	
	
	
	
	
	
}