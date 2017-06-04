package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.entity.Enemy;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Projectile;

public class MainScreen extends Screen{
	EntityManager e;
	
	private OrthoCamera camera;	
	@Override
	public void create() {
		System.out.print("Created");
		camera=new OrthoCamera();
		 e=new EntityManager();
		 screen="";
	}
	@Override
	public void update() {

		if(Gdx.input.isKeyPressed(Keys.ESCAPE)||e.gameOver()){
			screen="START";
		}
		
		camera.update();
		
		e.update();
	}
	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		
		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(TextureManager.BackGround, 0, 0);
		e.render(sb);
		sb.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		System.out.println("resize");
		camera.resize();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("dispose");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.print("pause");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.print("resume");
	}



}
