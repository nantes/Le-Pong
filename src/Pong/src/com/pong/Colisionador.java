package com.pong;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Colisionador {       
    public static boolean GolpeoPaddle(Rectangle r1, Rectangle r2) {
   
    	return !(r1.x > r2.x + r2.width || r1.x + r1.width < r2.x || r1.y > r2.y + r2.height || r1.y + r1.height < r2.y);

    }           
    
    public static boolean HayClick(Rectangle r, float x, float y) {
        return r.x <= x && r.x + r.width >= x &&
               r.y <= y && r.y + r.height >= y;
    }
}
