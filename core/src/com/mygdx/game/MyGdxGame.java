package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.Screen;
import com.mygdx.game.screens.ScreenManager;
import com.mygdx.game.screens.StartScreen;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Screen start;
	MainScreen gamePlay;
	String currentScreen;
	public static int WIDTH=800, HEIGHT=600;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		start=new StartScreen();
		gamePlay=new MainScreen();
		ScreenManager.setScreen(start);
		currentScreen="start";
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	if(ScreenManager.getCurrentScreen().screen.equals("MAIN")){
			
			ScreenManager.setScreen(gamePlay);
			ScreenManager.getCurrentScreen().resize(0,0);
			ScreenManager.getCurrentScreen().render(batch);
		}
	if(ScreenManager.getCurrentScreen().screen.equals("EXIT")){
		Gdx.app.exit();
	}
	
	
	if(ScreenManager.getCurrentScreen().screen.equals("START")){
		
		ScreenManager.setScreen(start);
		ScreenManager.getCurrentScreen().resize(0,0);
		ScreenManager.getCurrentScreen().render(batch);
	}
	
	
	
	
	
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().update();
		
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().render(batch);

			
		
		
		
		
		
	
	}
	
	@Override
	public void dispose () {
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
		
	}
	
	@Override
	public void resize(int width, int height){
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().resize(WIDTH, HEIGHT);
		
		
		
	}
	
	@Override
	public void pause(){
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().pause();
		
	}
	
	@Override
	public void resume(){
		if(ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().resume();
		
	}
	
	
	
}
