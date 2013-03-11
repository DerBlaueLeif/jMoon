package geras.jmoon.entites;

import geras.jmoon.world.Map;

import org.newdawn.slick.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.matthiasmann.twl.model.SimpleChangableListModel;

public class CheaterNPC extends NPCEntity {

	public CheaterNPC(SimpleChangableListModel<String> inventoryModel,
			String name, String title, int posX, int posY) {
		super(inventoryModel, name, title, posX, posY);
		width = 32;
		height = 32;
		try{
			this.entityImg = new Image("Sprites/Entities/Cheater.png");
		}
		catch(SlickException e){
			e.printStackTrace();
		}
	}
	
	public void interact(PlayerEntity player, Map map, Game game){
		player.getInventory().addItem("Sickel", 1);
		player.getInventory().addItem("Shovel", 1);
		player.getInventory().addItem("Water Bucket", 1);
		player.getInventory().addItem("Hoe", 1);
		player.getInventory().addItem("Fence", 64);
	}

}
