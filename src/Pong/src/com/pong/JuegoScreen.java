package com.pong;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.Juego.JuegoListener;

public class JuegoScreen implements Screen {
	
	
	
	OrthographicCamera camara;
	SpriteBatch batch;
	Pong game;
	
	Juego juego;
	JuegoListener juegoListener;
	
	int player1Score;
	int player2Score;
	String player1ScoreString;
	String player2ScoreString;
	
	FPSLogger fpslogger;
	
	
	
	public JuegoScreen(Pong game){
		//Inicializo camara y batch para dibujar
		this.game = game;
		camara = new OrthographicCamera(480,320);
		camara.position.set(480 / 2, 320 / 2, 0);
		batch = new SpriteBatch();
		
		//cargo el juego
		juego = new Juego(game);

		
		//seteo scores
		player1Score = 0;
		player2Score = 0;
		player1ScoreString = "0";
		player2ScoreString = "0";
	}

	public void update(float deltaTime) {
	
		
		//Calculo velocidad en base a input del usuario
		float velocidadPJ1 = 0;
		float velocidadPJ2 = 0;
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
			velocidadPJ1 = 200;
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
			velocidadPJ1 = -200;
		
		// si es un jugador no necesito escuchar pj2
		if(game.unJugador==false)
		{
			if(Gdx.input.isKeyPressed(Keys.A))
				velocidadPJ2 = 200;
			if(Gdx.input.isKeyPressed(Keys.Z))
				velocidadPJ2 = -200;
		}
		
		//actualizo las posiciones de los paddles
		juego.update(deltaTime, velocidadPJ1, velocidadPJ2);
		
		//si hubo cambios de score, actualizo la info
		if (juego.scoreP1 != player1Score || juego.scoreP2 != player2Score){
			player1Score = juego.scoreP1;
			player2Score = juego.scoreP2;
			player1ScoreString = "" + player1Score;
			player2ScoreString = "" + player2Score;
		}
	}
		

	public void pause() {
			// TODO Auto-generated method stub
			
		}

		public void resume() {
			// TODO Auto-generated method stub
			
		}

		public void dispose() {
			// TODO Auto-generated method stub
			
		}
		
		
		public void render(float deltaTime)
		{
		
			this.update(deltaTime);
			GLCommon gl = Gdx.gl;
			gl.glClearColor(1, 0, 0, 1);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			camara.update();
			batch.setProjectionMatrix(camara.combined);
			batch.enableBlending();
			
			//cargo temporales a los objetos para comodidad de codigo
			Bola bola = juego.bola;
			Paddle paddleP1 = juego.paddleP1;
			Paddle paddleP2 = juego.paddleP2;
			
			
			batch.begin();
		
			
			
			//muestro en pantalla
			batch.draw(Assets.juegoScreenBackgroundRegion, 0, 0, 480, 320);
			//scores
			Assets.font.draw(batch, player1ScoreString, 36, 300);
			Assets.font.draw(batch, player2ScoreString, 420, 300);
			//pelota
			batch.draw(Assets.bola, bola.position.x,bola.position.y);
			//paddle1
			batch.draw(Assets.paddle , paddleP1.position.x , paddleP1.position.y);
			//paddle2
			batch.draw(Assets.paddle , paddleP2.position.x , paddleP2.position.y);
			batch.end();
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resize(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}

}
