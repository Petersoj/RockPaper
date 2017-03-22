package rockpaper.view;

import javax.swing.JFrame;

import rockpaper.controller.RockController;

public class RockFrame extends JFrame {
	
	private RockPanel rockPanel;
	
	public RockFrame(RockController  rockController){
		super();
		this.rockPanel = new RockPanel(rockController);
		
		this.setupFrame();
	}
	
	private void setupFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Rock paper scissors");
		this.setContentPane(rockPanel);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}
