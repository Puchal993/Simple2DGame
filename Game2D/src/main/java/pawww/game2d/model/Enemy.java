/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Lukasz
 */
public class Enemy extends Tank implements IEnemy{
    
    private boolean hit = false;
    int z;
    
    Image image = new ImageIcon("enemy.jpg").getImage();
    
    public Enemy(int x, int y) {
        super(x, y);
        z = x + 4;
        yy = y;
    }
    private double yy;

    public void doMove() {
        yy += 0.25;
        y = (int) yy;
    }
    
    public boolean isHit() {
        return hit;
    }
    
    @Override
    public void setHit() {
        this.hit = true;
    }
    
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }
    
    public void printScore(Graphics g,String score) {
        
        g.setColor(Color.WHITE);
        g.drawString("Score "+score, 320, 475);
    }
    
    public int getZ() {
        return z;
    }
    
    public void setZ(int z) {
        this.z = z;
    }
    
      public  Rectangle getBounds(){
    return new Rectangle(x,y,75,75);
    }
    
}
