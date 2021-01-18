package dataStructures;

public class LinkedList<DataType> {
	
	private static class Node<DataType> {
		
		DataType value;
		
		Node<DataType> pointer;
		
		public Node(DataType input){
			
			this.value = input;
		}
	}
		Node<DataType> topOfList;
		Node<DataType> head = new Node<DataType>(null);
		private int sizeOfList = -1;
		
public void addToList(DataType value) {
			
			Node<DataType> inputNode = new Node<DataType>(value);
			
			if(topOfList == null) {
				
				topOfList = inputNode;
				head.pointer = inputNode;
				
				
			} else {
				
				topOfList.pointer = inputNode;
				
				topOfList = inputNode;
				
				}
			
			sizeOfList++;
		}
		
public Node<DataType> getNodeAtIndex(int indexPosition) throws NullPointerException, IllegalStateException {
	
	if(sizeOfList == -1) {throw new IllegalStateException("There are no Node's in this List!");}
	
	if(indexPosition > sizeOfList || indexPosition < 0) { throw new NullPointerException("Accessing Outside of the List!");}
	
	int counter = 0;
	Node<DataType> output = head.pointer;
	
	while(counter != indexPosition) {
		
		counter++;
		
		output = output.pointer;
	}
	
	return output;
	
}

public DataType deleteNodeAtIndex(int indexPosition){
	
	DataType output = getNodeAtIndex(indexPosition).value;
	
	
	
	if(sizeOfList == 0) {
		
		head = topOfList = null;
		
		sizeOfList--;
		
		return output;
	}
	
	
	if(indexPosition == 0) {
		
		
		head.pointer = head.pointer.pointer;
		
        sizeOfList--;
		
		return output;
		
	}
	
	if(indexPosition == sizeOfList) {
		
		getNodeAtIndex(indexPosition - 1).pointer = null;
		
		
	} else {
		
		
		Node<DataType> removedNode = getNodeAtIndex(indexPosition - 1);
		
		removedNode.pointer = removedNode.pointer.pointer;
		
		
	}
	
	sizeOfList--;
	return output;

	}
	
public boolean isListEmpty() {
	
	if(this.sizeOfList == -1) {
		
		return true;
		
	} else {
		
		return false;
	}
	
	
}

public int getSizeOfList() {
	
	return this.sizeOfList + 1;
	
}



public static void main(String[] args) {
	
	
	LinkedList<Integer> test = new LinkedList<Integer>();

	test.addToList(3);
	test.addToList(5);
	test.addToList(13);
	test.addToList(12);
	
	System.out.println(test.deleteNodeAtIndex(3));
	
	System.out.println(test.deleteNodeAtIndex(0));
	
	System.out.println(test.deleteNodeAtIndex(1));
	System.out.println(test.deleteNodeAtIndex(0));
	
	
	
	
	
}
	
	
}
		
		
	
	

