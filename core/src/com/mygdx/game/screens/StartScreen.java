package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;

public class StartScreen extends Screen{
	private OrthoCamera camera;	
	int x=150,y=380;
	int choice=0;
	TextureRegion t=new TextureRegion(TextureManager.BAR,32,32);
	@Override
	public void create() {
		// TODO Auto-generated method stub
		camera=new OrthoCamera();
		screen="START";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		camera.update();
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			switch(choice){
			case 0:screen="MAIN";  
			break;
			case 1:screen="EXIT";
			
			break;
			}
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.UP)){
			choice--;
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)){
			choice++;
			
		}
		if(choice<0){
			choice=1;
			
		}
		
		if(choice>1){
			choice=0;
			
		}
		if(choice==1)
			y=160;
		if(choice==0)
			y=380;
		
		
		
		
		
	}

	@Override
	public void render(SpriteBatch sb) {
		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(TextureManager.MAINSCREEN, 0, 0);
		sb.draw(t,x,y);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		camera.resize();
	}

	@Override
	public void dispose() {
	
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
}
