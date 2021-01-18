package dataStructures;

public abstract class AbstractBinaryTree<DataType> {
	
	protected static class Node<DataType>{
		
		public DataType value;
		
		public Node<DataType> leftNeighbour;
		public Node<DataType> rightNeighbour;
		
		public Node(DataType value){
			
			this.value = value;
			
		}
		
	}	
	
	private Node<DataType> root;
	
	public abstract boolean isGreaterThan(Node<DataType> current, Node<DataType> newNode);
		
	public void addToTree(DataType value) {
		
		Node<DataType> newNode = new Node<DataType>(value);
		
		if(root == null) { root = newNode;
		return;
		} else {
			
			doComparison(root, newNode);
			
		
		}
	
	}
	
	public void doComparison(Node<DataType> current, Node<DataType> newNode) {
	
		if(isGreaterThan(current, newNode) == true) {
			
			   if(current.leftNeighbour == null) { current.leftNeighbour = newNode;
			
			   }
			   
			   else {
				   
				   doComparison(current.leftNeighbour, newNode);
				   
				 }
			
			return;
			
		} else {
			
			if(current.rightNeighbour == null) {
				
				current.rightNeighbour = newNode;
			} else {
				
				doComparison(current.rightNeighbour, newNode);
				
			}
			
			
			return;
		}
	}	
		
	public DataType retrieveLargestValue() throws IllegalStateException{
		
		if(root == null) { throw new IllegalStateException("No Maximum in an empty tree!");}
		
		
		if(root.rightNeighbour == null) {
			
			DataType output = root.value;
			
			if(root.leftNeighbour != null) {
				
				root = root.leftNeighbour;
				
			} else {root = null;}
			
			return output;
		}
		
		else {
			
			Node<DataType> runner = root;
			Node<DataType> search = root.rightNeighbour;
			
			while(search.rightNeighbour != null) {
				
				
				search = search.rightNeighbour;
				runner = runner.rightNeighbour;
				
				
			}
			
			DataType largest = search.value;
			
			if(search.leftNeighbour == null) {
				
		
				runner.rightNeighbour = null;
			} else {
				
				
				runner.rightNeighbour = search.leftNeighbour;
			
			}
			
			return largest;
			
		}
		
		
		
		
		
		
		
		
	}
	
	public DataType pushSmallestValue() throws IllegalStateException {
		
		if(root == null) { throw new IllegalStateException("Tree is empty!");}
		
		if(root.leftNeighbour == null) {
			
			DataType output = root.value;
			
			if(root.rightNeighbour == null) {
				
				root = null;
				
				
			} else { root = root.rightNeighbour;}
			
			return output;
		} else {
			
			Node<DataType> runner = root;
			Node<DataType> search = root.leftNeighbour;
			
			
			while(search.leftNeighbour != null) {
				
				
				search = search.leftNeighbour;
				runner = runner.leftNeighbour;
				
				
				
			}
			
			DataType outPutValue = search.value;
			
			if(search.rightNeighbour == null) {
				
				runner.leftNeighbour = null;
				
			} else {
				
				
				runner.leftNeighbour = search.rightNeighbour;
				
			}
			
			return outPutValue;
		}
		
		
		
		
		
		
	}
	
	
	public DataType getRootValue() throws NullPointerException {
		
		if(root == null) {throw new NullPointerException("The tree is empty!");}
		
		return root.value;
		
	}
		
		
	public boolean isTreeEmpty() {
		
		if(root == null) {return true;}
		else {return false;}
		
		
		
	}	
		
	
		


}
