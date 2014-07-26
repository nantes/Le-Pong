package com.pong;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class Main {
	public static void main(String[] argv){
		new JoglApplication(new Pong(), "Pong", 480, 320, false);
	}
}
