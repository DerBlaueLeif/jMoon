package geras.jmoon.gui;

import geras.jmoon.entites.PlayerEntity;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BasicPane extends BasicGUIElement{
	
	protected int posX;
	protected int posY;
	protected int width;
	protected int height;
	
	protected boolean visible;

	protected Image backGroundImg;
	
	
	public BasicPane(BasicGUIElement parent, int x, int y, int width, int height, String imageFile){
		super(parent);
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
		
		try {
			backGroundImg = new Image(imageFile);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void draw(){
		if(visible){
			if(backGroundImg != null){
				backGroundImg.draw(posX, posY, width, height);
			}
			drawChildren();
		}
	}
	
	@Override
	public void handleInput(Input input, PlayerEntity player){
		if(visible){
			childrenInput(input, player);
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && isHit(input.getAbsoluteMouseX(), input.getAbsoluteMouseY())){
				if(parent != null){
					parent.prioritise(this);
				}
				input.clearMousePressedRecord();
			}
		}
	}
	
	/**
	 * check if the coordinates lie on the pane
	 * @param x - x coordinate
	 * @param y - y coordinate
	 */
	public boolean isHit(int x, int y){
		boolean hitX = x >= posX && x <= posX + width;
		boolean hitY = y >= posY && y <= posY + height;
		return hitX && hitY;
	}
	
	///////////////////////////////////////////////////////
	//
	//			Big block of getter/setters
	//
	///////////////////////////////////////////////////////
	
	public boolean isVisible(){
		return visible;
	}
	
	public void setVisibility(boolean value){
		visible = value;
	}
	
}