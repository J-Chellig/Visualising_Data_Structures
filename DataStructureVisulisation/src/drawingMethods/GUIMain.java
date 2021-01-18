package drawingMethods;

import javafx.scene.canvas.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import dataHandling.*;

public class GUIMain extends Application {

	private int numberOfRows = 30;
	
	private ComboBox<String> inputBox = new ComboBox<String>();
   
	private Canvas mainStage = new Canvas(500, 500);
    private Label textInfo = new Label("Type of Data Structure:");
    private Pane root = new Pane(inputBox, mainStage, textInfo);
	
		
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public void start(Stage stage) {
		
		mainStage.getGraphicsContext2D().strokeRect(0, 0, 500, 500);
		
		textInfo.relocate(90, 524);
        inputBox.relocate(240, 520);
        inputBox.setValue("Stack");
		
        inputBox.getItems().addAll("Stack", "Random Access", "Binary Tree Largest", "Binary Tree Smallest", "Queue");
		
		
		Scene scene = new Scene(root, 500, 570);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Data Structure Searching");
		
		scene.setOnMouseClicked(evt -> startAnimation(evt));
		
		}
	
	
	
	public void startAnimation(MouseEvent evt) {
		
		
		
		DataTable computationTable = selectTypeOfStructure();
		DrawingMethods drawingStation = new DrawingMethods(computationTable, this.mainStage);
		computationTable.exploreGrid(drawingStation.convertexToMatrix(evt.getX()), drawingStation.convertexToMatrix(evt.getY()));
		
		AnimationTimer anim = new AnimationTimer() {
			
			public void handle(long timer) {
				
				computationTable.processTopOfPile();
				drawingStation.drawAll();
				}
			};
		
		anim.start();
		
	
		}
		
	
	public DataTable selectTypeOfStructure() {
		
		String inputData = inputBox.getValue();
		
		switch(inputData) {
		
		case "Stack": {
		
		DataTable stack = new StackDataSorting(numberOfRows);
		
		return stack;
		
		}
		
		case "Random Access": {
			
			
		DataTable random = new RandomLinkedListSorting(numberOfRows);
		
		return random;
			
		}
		
		case "Binary Tree Smallest": {

		DataTable binaryTreeSmall = new BinaryTreeSmallestRetrival(numberOfRows);
		
		return binaryTreeSmall;
			
		}
		
		case "Queue": {
			
		DataTable implementedQueue = new ImplementedQueue(numberOfRows);
		
		return implementedQueue;
			
		}
		
		default: {
			
			DataTable binaryTreeLarge = new BinaryTreeLargestRetrival(numberOfRows);
			
			return binaryTreeLarge;
			
			
			
		}
		
		
		}
		
		
		
		
		
	}
		
}
	
	
