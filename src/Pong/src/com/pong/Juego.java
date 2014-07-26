package com.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class Juego {
	public interface JuegoListener {
		public void bump();
	}
	
	public static final float JUEGO_ANCHO = 480;
	public static final float JUEGO_LARGO = 320;
	
	public final Paddle paddleP1;
	public final Paddle paddleP2;
	public final Bola bola;
	
	Pong game;
	
	public int scoreP1;
	public int scoreP2;
	
	
	FPSLogger fpslogger;
	
	public Juego(Pong game)
	{
		this.game = game;
		//inicializo todo
		this.bola = new Bola(JUEGO_ANCHO/2,JUEGO_LARGO/2);
		this.paddleP1 = new Paddle(5,JUEGO_LARGO/2);
		this.paddleP2 = new Paddle(JUEGO_ANCHO-15,JUEGO_LARGO/2);
		this.scoreP1 = 0;
		this.scoreP2 = 0;
		
	}
	
	public void update(float deltaTime, float velocidadP1 , float velocidadP2){
		//actualizo posiciones
		updateBola(deltaTime);
		updatePaddles(deltaTime, velocidadP1, velocidadP2);
		checkCollisions();
		// si es un jugador, pj2 sigue la pelota
		if (game.unJugador)
			paddleP2.SeguirBola(deltaTime,bola);
	}
	
	public void updateBola(float deltaTime){
		bola.update(deltaTime);
		//Gdx.app.log("rectangulo valor", String.valueOf(paddleP2.bounds.y));
		
		//si pega en limite de arriba/abajo invierto el recorrido
		if (bola.position.y >= (JUEGO_LARGO-bola.getHeight()-5) && bola.velocidad.y > 0 )
			bola.velocidad.y *=-1;
		if (bola.position.y <= (0+bola.getHeight()) && bola.velocidad.y < 0 )
			bola.velocidad.y *= -1;
		
		
		//si sale de limites de algun jugador, marco score
		if (bola.position.x >= JUEGO_ANCHO){
			scoreP1++;
			bola.score();
		}
		if (bola.position.x <= 0){
			scoreP2++;
			bola.score();
		}
		
	}
	
	public void updatePaddles(float deltaTime, float velocidadP1, float velocidadP2){
		//muevos paddles
		paddleP1.velocidad.y = velocidadP1;
		paddleP2.velocidad.y = velocidadP2;
		paddleP1.update(deltaTime);
		paddleP2.update(deltaTime);
	}
	
	public void checkCollisions(){
		// si golpea con el pj1 
		if (Colisionador.GolpeoPaddle(paddleP1.bounds, bola.bounds) && bola.velocidad.x < 0){
			//invierto x a bola
			bola.velocidad.x = bola.velocidad.x * -1;
			//acelero la bola
			bola.velocidad.x = bola.velocidad.x * 1.1f;
			bola.velocidad.y = bola.velocidad.y * 1.1f;
			
			Assets.playSound(Assets.sndRebote);
		}
		// si golpea con el pj 2
		if (Colisionador.GolpeoPaddle(paddleP2.bounds, bola.bounds) && bola.velocidad.x > 0){
			//invierto x a bola
			bola.velocidad.x = bola.velocidad.x * -1;
			//acelero la bola
			bola.velocidad.x = bola.velocidad.x * 1.1f;
			bola.velocidad.y = bola.velocidad.y * 1.1f;
			
			Assets.playSound(Assets.sndRebote);
		}
	}
	
}
	
	

