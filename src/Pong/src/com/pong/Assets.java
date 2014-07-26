package com.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture textureatlas;
	public static TextureRegion juegoScreenBackgroundRegion;
	public static TextureRegion menuPrincipalScreenRegion; //cambiarlo por un jugador
	public static TextureRegion paddle;
	public static TextureRegion bola;
	public static BitmapFont font;
	
	public static Sound sndRebote;
	
	public static Texture loadTexture(String file){
		return new Texture(Gdx.files.internal(file));
	}
	
	public static void load(){
		//cargo el atlas
		textureatlas.setEnforcePotImages(false);
		textureatlas = loadTexture("data/screen_atlas.png");
		//background
		juegoScreenBackgroundRegion = new TextureRegion(textureatlas, 0,0,480,320);
		//unjugador
		menuPrincipalScreenRegion = new TextureRegion(textureatlas, 0,320,480,320);
		//dosjugadores
		//dosJugadores = new TextureRegion(textureatlas, 0, 320, 240, 320);
		
		
		//paddle y bola
		paddle = new TextureRegion(textureatlas, 0,400,10,64);
		bola = new TextureRegion(textureatlas, 0,400,10,10);
		
		
		//fuente para el score
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);
		
		//sonido de rebote
		sndRebote = Gdx.audio.newSound(Gdx.files.internal("data/ball_bump.wav"));
	}
	
	public static void playSound(Sound sound){
		sound.play(1);
	}

}
