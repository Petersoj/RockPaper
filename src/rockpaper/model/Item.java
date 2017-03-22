package rockpaper.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Item {
	
	public String itemName;
	public ImageIcon itemIcon;
	
	public Item(String itemName){
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}
	
	public ImageIcon getItemIcon() {
		return itemIcon;
	}

	public void setItemIcon(ImageIcon itemIcon) {
		this.itemIcon = new ImageIcon(itemIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	}
}