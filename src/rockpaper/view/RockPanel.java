package rockpaper.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import rockpaper.controller.RockController;
import rockpaper.model.Item;

public class RockPanel extends JPanel {
	
	private RockController rockController;
	
	private SpringLayout springLayout;
	private JLabel computerLabel;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorsButton;
	
	public RockPanel(RockController rockController){
		super();
		this.rockController = rockController;
		
		this.springLayout = new SpringLayout();
		this.computerLabel = new JLabel("Click a Button");
		this.rockButton = new JButton(rockController.getRock().getItemName());
		this.paperButton = new JButton(rockController.getPaper().getItemName());
		this.scissorsButton = new JButton(rockController.getScissors().getItemName());
		
		this.setupPanel();
		this.setupLayout();
		this.setupListeners();
	}
	
	private void setupPanel(){
		
		this.computerLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.rockButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		this.paperButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		this.scissorsButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		this.rockButton.setIcon(rockController.getRock().getItemIcon());
		this.paperButton.setIcon(rockController.getPaper().getItemIcon());
		this.scissorsButton.setIcon(rockController.getScissors().getItemIcon());
		
		this.rockButton.setVerticalTextPosition(JLabel.BOTTOM);
		this.rockButton.setHorizontalTextPosition(JLabel.CENTER);
		this.paperButton.setVerticalTextPosition(JLabel.BOTTOM);
		this.paperButton.setHorizontalTextPosition(JLabel.CENTER);
		this.scissorsButton.setVerticalTextPosition(JLabel.BOTTOM);
		this.scissorsButton.setHorizontalTextPosition(JLabel.CENTER);
		
		this.setLayout(springLayout);
		this.add(computerLabel);
		this.add(rockButton);
		this.add(paperButton);
		this.add(scissorsButton);
		
		this.setBackground(Color.WHITE);
	}
	
	private void setupLayout(){
		springLayout.putConstraint(SpringLayout.NORTH, computerLabel, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, computerLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, paperButton, 40, SpringLayout.SOUTH, computerLabel);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, paperButton, 0, SpringLayout.HORIZONTAL_CENTER, computerLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, rockButton, 0, SpringLayout.NORTH, paperButton);
		springLayout.putConstraint(SpringLayout.EAST, rockButton, -20, SpringLayout.WEST, paperButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 0, SpringLayout.NORTH, paperButton);
		springLayout.putConstraint(SpringLayout.WEST, scissorsButton, 20, SpringLayout.EAST, paperButton);
	}
	
	private void setupListeners(){
		this.rockButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				computerLabel.setText(getRandomGameAnswer(rockController.getRock())); // rock listener
			}
		});
		this.paperButton.addActionListener(new ActionListener() { // paper listener
			@Override
			public void actionPerformed(ActionEvent e) {
				computerLabel.setText(getRandomGameAnswer(rockController.getPaper()));
			}
		});
		this.scissorsButton.addActionListener(new ActionListener() { // scissors listener
			@Override
			public void actionPerformed(ActionEvent e) {
				computerLabel.setText(getRandomGameAnswer(rockController.getScissors()));
			}
		});
	}
	
	private String getRandomGameAnswer(Item clickedItem){
		int randomNum = (int) (Math.random() * 2);
		String answer = "";
		
		if(randomNum == 0){ // rock
			if(clickedItem.equals(rockController.getRock())){
				answer += "It\'s a tie!";
			}else if(clickedItem.equals(rockController.getPaper())){
				answer += "Oh dang I lost!";
			}else if(clickedItem.equals(rockController.getScissors())){
				answer += "I win!";
			}
			answer += " I chose Rock!";
		}else if(randomNum == 1){ // paper
			if(clickedItem.equals(rockController.getRock())){
				answer += "Haha you lost!";
			}else if(clickedItem.equals(rockController.getPaper())){
				answer += "It\'s a tie!";
			}else if(clickedItem.equals(rockController.getScissors())){
				answer += "Oh dang I lost!";
			}
			answer += " I chose Paper";
		}else{ // scissors
			if(clickedItem.equals(rockController.getRock())){
				answer += "Oh dang I lost!";
			}else if(clickedItem.equals(rockController.getPaper())){
				answer += "I have won!";
			}else if(clickedItem.equals(rockController.getScissors())){
				answer += "It\'s a tie!";
			}
			answer += " I chose Scissors!";
		}
		return answer;
	}
}
