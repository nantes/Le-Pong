package com.pong;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Objetos extends Rectangle{
	public final Vector2 position;
	public final Rectangle bounds;
	public final Vector2 velocidad;
	public final Vector2 aceleracion;
	
	public Objetos(float x, float y, float width, float height){
		//guardo posicion, velocidad, aceleracion y genero bounds para chequear colisiones
		this.position = new Vector2(x,y);
		this.bounds = new Rectangle(x-width/2, y-height/2, width, height);
		velocidad = new Vector2();
		aceleracion = new Vector2();
	}

}
