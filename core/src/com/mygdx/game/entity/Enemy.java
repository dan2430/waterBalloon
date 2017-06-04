package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;

public class Enemy extends Entity{
	boolean movingRight=true;
	
	public Enemy( Vector2 pos, Vector2 direction) {
		super(TextureManager.ENEMY, pos, direction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {

		if(pos.x>0&&!movingRight){
			setDirection(-200,0);
			movingRight=false;
			if(pos.x<=70){
				movingRight=true;
			}
				
			
		}
		
		if(pos.x<MyGdxGame.WIDTH&&movingRight){
			setDirection(200,0);
			movingRight=true;
			if(pos.x>=MyGdxGame.WIDTH-160)
				movingRight=false;
			
			
		}
		
		
		
		
		
	pos.add(direction);
		
	}

}
