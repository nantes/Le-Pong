package com.pong;

import com.badlogic.gdx.Game;

public class Pong extends Game{
	//pantallas
	JuegoScreen 		screenJuego;
	MenuPrincipal 		menuPrincipal;
	boolean unJugador = true;
	

	
	
	@Override
	public void create() {
		//cargo assets en memoria
		Assets.load();
		
		//creo pantallas y cargo por defecto menuPrincipal
		screenJuego = new JuegoScreen(this);
		menuPrincipal = new MenuPrincipal(this);
		setScreen(menuPrincipal);
	}

	
	
}
