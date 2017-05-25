/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Lukasz
 */
public interface IEnemy {
    public void doMove();
    public void render(Graphics g);
    
    public int getX();
    public int getY();
    public void setHit();
     public Rectangle getBounds( );
   public boolean isHit();
  
}
