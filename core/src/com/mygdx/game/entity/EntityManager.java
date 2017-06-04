package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.TextureManager;

public class EntityManager {
		private Player player;
		private Projectile m;
		private Enemy e;
		Array<Projectile> projectiles=new Array<Projectile>();
		SideBar score;
		Rectangle pCollision;
		//square the size of a projectile
		

	public EntityManager(){
		player=new Player(new Vector2(470,-20), new Vector2(0,0), this);
		m=new Projectile(new Vector2(470,15));
		e=new Enemy(new Vector2(20,520),new Vector2(0,0));
		score=new SideBar(m);


	}
	public void render(SpriteBatch sb){
		player.render(sb);
		score.render(sb);
		
		
		
		
		m.render(sb);
		e.render(sb);
		
		
	}
	public void update(){
		player.update();
		//if its not moving, it sets the bullet to player pos
		if(!m.inMotion)
			m.setPosition(player.getPosition().x+42,m.getPosition().y);
		
	
		m.update();
		e.update();
		pCollision=new Rectangle(m.getPosition().x,m.getPosition().y,64,64);
		//collision detection
		
		if(pCollision.overlaps(e.getBounds())){
			System.out.print(pCollision.getWidth());
			
			score.update(true);
			
			
			
			m.resetPos();
		}
	}
	public void addProjectile(Projectile p){
		projectiles.add(p);
		
		
	}
	public boolean gameOver(){
		return score.win;
	}
	
	
	

}
