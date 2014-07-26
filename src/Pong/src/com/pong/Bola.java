package com.pong;

public class Bola extends Objetos {
	
	
	public static final float BOLA_ANCHO = 10;
	public static final float BOLA_LARGO = 10;
	
	
	public Bola(float posX, float posY){
		super(posX, posY, BOLA_ANCHO, BOLA_LARGO);
		
		//le doy velocidad por defecto
		this.velocidad.set(100, 100);
	}
	
	public void update(float deltaTime){
		//actualizo posicion y limites de rebote de la bola
		position.add(velocidad.x * deltaTime, velocidad.y * deltaTime);
		
		//actualizo pos de cuadrado que colisiona
		bounds.x = position.x - bounds.width/2;
		bounds.y = position.y - bounds.height/2;		
	}
	
	
	public void bounce(){
		velocidad.x = velocidad.x * -1;
	}
	
	
	public void score(){
		//si hay gol, reseteo la bola
		if(position.x>480)
		{
			//score pj1, saca pj2
			velocidad.set(-100,-100);		
		}
		else
			//socre pj2, saca pj1
			velocidad.set(100,100);
		position.set(480/2,320/2);
		
		
		//actualizo pos de cuadrado que colisiona
		bounds.x = position.x - bounds.width/2;
		bounds.y = position.y - bounds.height/2;
	}
	

}
