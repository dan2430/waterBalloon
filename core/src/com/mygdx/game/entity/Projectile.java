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

public class Projectile extends Entity{
	Boolean inMotion=false;
	TextureRegion[] animFrame;
	 Animation<TextureRegion> animation;
	   float elapsedTime;
	   int frame=0;
	
	
	public Projectile(Vector2 pos) {
		

	     
		
		
		
		
		super(TextureManager.MISSILE, pos, new Vector2(0,0));
		 Texture img;
		TextureRegion[][] tmpFrames = TextureRegion.split(TextureManager.MISSILE,49,49);
		animFrame=new TextureRegion[4];
		animFrame[0]=tmpFrames[0][0];
		animFrame[1]=tmpFrames[0][1];
		animFrame[2]=tmpFrames[0][2];
		animFrame[3]=tmpFrames[0][3];
		animation=new Animation(1f/16f,animFrame);
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		

		if(Gdx.input.isKeyPressed(Keys.SPACE)&&!inMotion){
			inMotion=true;
			System.out.println("SPACE");
			

		}

		if(checkEnd()&&inMotion)
			setDirection(0,300);
		else{
			setDirection(0,0);
			resetPos();
		}

		pos.add(direction);


	}
	public boolean checkEnd(){
		//return true if it is within
		return pos.y<MyGdxGame.HEIGHT-50;

	}
	public void resetPos(){
		this.pos.y=60;
		inMotion=false;

	}

	public void setPosition(float x, float y) {
		pos.x=x;
		pos.y=y;


	}

	public void render(SpriteBatch sb) {
		if(frame>2)
			frame=0;
		else
			frame++;
		
		 elapsedTime += Gdx.graphics.getDeltaTime();
		 if(inMotion)
			 sb.draw(animation.getKeyFrame(elapsedTime, true), pos.x, pos.y);
		 else{
			 sb.draw(animFrame[0],pos.x,pos.y);
				}
			 
		 
	}


}
