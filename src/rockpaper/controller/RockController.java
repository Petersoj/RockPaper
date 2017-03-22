package rockpaper.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import rockpaper.model.Item;
import rockpaper.view.RockFrame;

public class RockController {
	
	private RockFrame rockFrame;
	
	private Item rock;
	private Item paper;
	private Item scissors;
	
	public RockController(){
		this.rock = new Item("Rock");
		this.paper = new Item("Paper");
		this.scissors = new Item("Scissors");
		
		try {
			
			this.rock.setItemIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/rockpaper/controller/rock.jpg"))));
			this.paper.setItemIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/rockpaper/controller/paper.jpg"))));
			this.scissors.setItemIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/rockpaper/controller/scissors.jpg"))));
			
			this.rockFrame = new RockFrame(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		
	}

	public Item getRock() {
		return rock;
	}

	public void setRock(Item rock) {
		this.rock = rock;
	}

	public Item getPaper() {
		return paper;
	}

	public void setPaper(Item paper) {
		this.paper = paper;
	}

	public Item getScissors() {
		return scissors;
	}

	public void setScissors(Item scissors) {
		this.scissors = scissors;
	}

}
