package com.pong;

public class Paddle extends Objetos{
	public static final float PADDLE_ANCHO= 10;
	public static final float PADDLE_LARGO = 60.5f;
	public static final float PADDLE_VELOCIDAD = 200;
	
	public Paddle(float x, float y){
		super(x, y, PADDLE_ANCHO, PADDLE_LARGO);
	}
	
	public void update(float deltaTime){
		//actualizo posicion y limites de rebote del paddle
			this.position.add(velocidad.x * deltaTime, velocidad.y * deltaTime);
			
		//no dejo que se vaya fuera de pantalla
		if(position.y > (320-PADDLE_LARGO))
			this.position.y = 320-PADDLE_LARGO;
		if (position.y < 0)
			this.position.y = 0;
		
		//actualizo bounds
		bounds.x = position.x - bounds.width/2;
		bounds.y = position.y;

	}

	public void SeguirBola(float deltaTime,Bola bola)
	{
	//sigue la pelota con su velocidad propia
		if((bola.position.y-(PADDLE_LARGO/2)) > position.y)
			this.position.add(velocidad.x * deltaTime, PADDLE_VELOCIDAD * deltaTime);
		else if(bola.position.y-(PADDLE_LARGO/2) < position.y)
			this.position.add(velocidad.x * deltaTime, PADDLE_VELOCIDAD * deltaTime * -1);
		
	//actualizo bounds para colisiones
	bounds.x = position.x - bounds.width/2;
	bounds.y = position.y ;
	}
}
