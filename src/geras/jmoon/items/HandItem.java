package geras.jmoon.items;

import geras.jmoon.settings.Settings;
import geras.jmoon.world.Map;
import geras.jmoon.world.WorldElements;

public class HandItem extends UsableItem {

	public HandItem(){
		super("Hand", 1, 1, 1);
	}
	
	@Override
	public void useWorld(int x, int y, Map map) {
		//Currently: switch from Gras to Gravel
		int fieldX = x / Settings.tileWidth;
		int fieldY = y / Settings.tileHeight;
		int value = map.getField("Ground", fieldX, fieldY);
		if(value == WorldElements.GRASS_VALUE){
			map.setField("Ground", fieldX, fieldY, WorldElements.GRAVEL_VALUE);
		}
		else{
			map.setField("Ground", fieldX, fieldY, WorldElements.GRASS_VALUE);
			map.setField("Plants", fieldX, fieldY, -1);
		}
	}

}
