package com.pong;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MenuPrincipal implements Screen  {
	//camara
	OrthographicCamera 			camara;
	//batcher para dibujar
	SpriteBatch 				batch;
	//boton un jugador
	Rectangle 					btnUnJugador;
	//boton dos jugadores
	Rectangle 					btnDosJugadores;
	//click del mouse
	Vector3 					click;
	
	//debug
	FPSLogger 					fpslogger;
	
	Pong game;
	
	public MenuPrincipal(Pong game){
		this.game  = game;
		camara = new OrthographicCamera(480,320);
		camara.position.set(480 / 2, 320 / 2, 0);
		//instancio batch
		batch = new SpriteBatch();
		//guardo botones (cada porcion es una opcion)
		btnUnJugador = new Rectangle(0,0,240,320);
		btnDosJugadores = new Rectangle(241,0,240,320);
		
		//instancio click	
		click = new Vector3();
		//debug
		fpslogger = new FPSLogger();
	}

	public void update() {
		// si hay click de mouse en pantalla
		if (Gdx.input.justTouched()){
			
			//transformo coordenadas a mundo
			camara.unproject(click.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			
			//si hay click en lado un jugador seteo true
			if(Colisionador.HayClick(btnUnJugador, click.x, click.y))
				game.unJugador = true;
				
			//si hay click en lado dos jugadores seteo false
			if (Colisionador.HayClick(btnDosJugadores, click.x, click.y))
				game.unJugador = false;
			
			//cargo pantalla de juego	
			game.setScreen(game.screenJuego);
			Assets.playSound(Assets.sndRebote);
			return;
		}
	}

	
	@Override
	public void render(float arg0) {
		
		this.update();
		GLCommon gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camara.update();
		batch.setProjectionMatrix(camara.combined);
		batch.begin();
		//dibujo background
		batch.draw(Assets.menuPrincipalScreenRegion, 0, 0, 480, 320);
		batch.end();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


}
