package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;

public class SideBar {
	
	Texture bar=TextureManager.BAR;
	Texture currentProjectile;
	TextureRegion t=new TextureRegion(bar,32,1);
	boolean win=false;
	//lives start at 0 and go up to 10
	int enemyLives=0;
	public SideBar(Projectile p){
		currentProjectile=p.texture;
		
		
	}
	
	public void update(boolean hit){
		if(hit){

			enemyLives++;
				t.setRegion( 0,32,32,32*enemyLives);
		}
		if(enemyLives==10){
			System.out.println("WINNER");
			win=true;
		}
		
		
	}
	
	public void render(SpriteBatch sb){
		

		sb.draw(t, 10,140);
		
	}
	
	
	
}
