package drawingMethods;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import dataHandling.*;


public class DrawingMethods {
	
	private DataTable mainTable;
	private Canvas mainCanvas;
	private double squareSize;
	private GraphicsContext g;
	
	public DrawingMethods(DataTable data, Canvas mainScene) {
		
		this.mainTable = data;
		this.mainCanvas = mainScene;
		
		this.squareSize = mainCanvas.getWidth()/((double) (mainTable.getGridLength()));
		g = mainCanvas.getGraphicsContext2D();
		
		}


	
	public void drawGridLines() {
		
		g.setStroke(Color.BLACK);
		
		for(int i = 0; i <= mainTable.getGridLength(); i++) {
			
			g.strokeLine(i*squareSize, 0, i*squareSize, mainCanvas.getHeight());
			
			g.strokeLine(0, i*squareSize, mainCanvas.getWidth(), i*squareSize);
			
		}
		
		
	}
	
	public void setFill(int row, int col) {
		
		State currentState = mainTable.getGrid()[row][col];
		
		switch(currentState){
			
		case Unknown: {
		
				g.setFill(Color.WHITE);
		return;
		
		}
		
		case Visited: {
			
				g.setFill(Color.GRAY);
		return;
			}
			
		case Processed: {
				
				g.setFill(Color.RED);
		return;
				
			}
		}
	}
	
	public void drawSquare(int row, int col) {
		
		setFill(row, col);
		
		g.fillRect(row*squareSize, col*squareSize, squareSize, squareSize);
		
	}
	
	public void drawAll() {
		
		for(int i = 0; i < mainTable.getGridLength(); i++) {
			
			for(int j = 0; j < mainTable.getGridLength(); j++) {
				
				drawSquare(i, j);
				
			}
			
			
		}
		
		
		drawGridLines();		
		
}

	
	public int convertexToMatrix(double x) {
		
		return 
				
			(int)((x - x%squareSize)/squareSize);	
		}
	

}
