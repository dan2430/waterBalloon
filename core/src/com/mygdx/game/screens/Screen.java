package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {
	
	public String screen;
	//contains all caps string about what screen it is
	public abstract void create();
	
	public abstract void update();
	
	public abstract void render(SpriteBatch sb);	
	
	public abstract void resize(int width, int height);
	
	public abstract void dispose();
	
	public abstract void pause();
	
	public abstract void resume();
}
