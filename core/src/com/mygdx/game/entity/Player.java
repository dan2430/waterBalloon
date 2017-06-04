package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;

public class Player extends Entity {
	TextureRegion[] animFrame;
	 Animation<TextureRegion> animation;
	   float elapsedTime;
	   int frame=0;
	   String d="";

	public Player( Vector2 pos, Vector2 direction, EntityManager em) {
		super(TextureManager.PLAYER, pos, direction);
		// TODO Auto-generated constructor stub
		
		
		TextureRegion[][] tmpFrames = TextureRegion.split(TextureManager.PLAYERANIM,128,128);
		animFrame=new TextureRegion[5];
		animFrame[0]=tmpFrames[0][0];
		animFrame[1]=tmpFrames[0][1];
		animFrame[2]=tmpFrames[0][2];
		animFrame[3]=tmpFrames[0][3];
		animFrame[4]=tmpFrames[0][4];
		animation=new Animation(1f/16f,animFrame);
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Keys.LEFT)&&pos.x>70){
			setDirection(-300,0);
			d="LEFT";
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)&&pos.x<MyGdxGame.WIDTH-160){
			setDirection(300,0);
			d="RIGHT";
		}
		else{
			setDirection(0,0);
			d="NONE";
		}
	
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			d="NONE";
		}
		
		
		
		
		
		
		

		pos.add(direction);

		




	}
	public void render(SpriteBatch sb){
		 elapsedTime += Gdx.graphics.getDeltaTime();
		 if(d.equals("LEFT")){
			 sb.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y);
		 }
		 else if(d.equals("RIGHT")){
			 sb.draw(animation.getKeyFrame(elapsedTime,true), pos.x+128, pos.y, 0, 0, -128, 128, 1 , 1, 0);
		 }
		 else{
			 sb.draw(TextureManager.PLAYER, pos.x, pos.y);
		 }
		
	}
	
	
	

}
