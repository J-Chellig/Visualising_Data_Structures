package dataHandling;

import drawingMethods.State;

public abstract class DataTable {

	
	private State[][] grid;
	
	public DataTable(int n) {
		
		
		grid = new State[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				grid[i][j] = State.Unknown;
				}
			
		}
		
}

	public State[][] getGrid() {
		return grid;
	}
	
	public int getGridLength() {
		
		return this.grid.length;
	}
	
	public boolean hasBeenProcessed = false;

	
	public void printGrid() {
		
       for(int i = 0; i < grid.length; i++) {
			
    	   
    	   if(i != 0) {
    	   System.out.println();}
    	   
			for(int j = 0; j < grid.length; j++) {
				
				System.out.print(grid[i][j].toString() + " ");
				}
			
		}
		
} 
	

	public abstract void addToStructure(int[] coords);

	public abstract int[] retrieveRecentCo_ords();
	
	
	public void exploreGrid(int row, int col) {
		
		
		if(row < 0 || col < 0 || row >= grid.length || col >= grid.length) {
			
			return;
			
		}
		
		if(this.grid[row][col] == State.Visited || this.grid[row][col] == State.Processed) {
			
			return;
			
		} else {
			
			this.grid[row][col] = State.Visited;
			
			int[] coords = {row, col};
			
			addToStructure(coords);
			
			
			
			    exploreGrid(row, col+1);
				exploreGrid(row, col-1);
				exploreGrid(row-1, col);
				exploreGrid(row+1, col);
				
		}
		
	}
	
	public void processTopOfPile() {
		
		int[] currentCords = retrieveRecentCo_ords();
		
		if(currentCords[0] == -1) {
			
			this.hasBeenProcessed = true;
			
			return;}
		
		this.grid[currentCords[0]][currentCords[1]] = State.Processed;
	}
	
	
	
}
