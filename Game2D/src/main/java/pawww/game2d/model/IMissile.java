/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author Lukasz
 */
public interface IMissile {
      public void doMove(LinkedList<IEnemy> e);
    public void render(Graphics g);
    
    public int getX();
    public int getY();
    
    public Rectangle getBounds();
}
