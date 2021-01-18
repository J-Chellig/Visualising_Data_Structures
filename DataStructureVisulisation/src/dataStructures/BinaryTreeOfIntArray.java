package dataStructures;

public class BinaryTreeOfIntArray extends AbstractBinaryTree<int[]> {

	
	public boolean isGreaterThan(Node<int[]> current, Node<int[]> newNode) throws IllegalStateException {
		
		if(this.getRootValue() == null) {throw new IllegalStateException("Tree is empty!");}
		
		else {
			
			if(EuclideanNorm(this.getRootValue(), current.value) <= EuclideanNorm(this.getRootValue(), newNode.value)) {
				
				return false;
				
			} else { return true;}
			
			
		}
		
	}

	
	
	
	public static double EuclideanNorm(int[] v, int[] u) {
		
		double x1 = v[0];
		double y1 = v[1];
		double x2 = u[0];
		double y2 = u[1];
		
		return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
		
		
		
		
	}
	
	
		
		}
	

