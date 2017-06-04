package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	public static Texture PLAYER =new Texture (Gdx.files.internal("playertest.png"));
	public static Texture MISSILE =new Texture (Gdx.files.internal("balloonAnimRESIZ.png"));
	public static Texture ENEMY =new Texture (Gdx.files.internal("enemy.png"));
	public static Texture BackGround=new Texture(Gdx.files.internal("background.png"));
	public static Texture BAR=new Texture(Gdx.files.internal("health.png"));
	public static Texture MAINSCREEN=new Texture(Gdx.files.internal("mainscreen.png"));
	public static Texture PLAYERANIM=new Texture(Gdx.files.internal("leftwalk.png"));
	
	
}
