/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import pawww.game2d.model.Player;

/**
 *
 * @author Lukasz
 */
public class GameView {
    
   // private MissileView m;
    public Player p = new Player(320, 400);
    private Image ship = new ImageIcon("sheep.gif").getImage();
    
    public GameView() {
    //    this.m = m;
    }
    
    public void render(Graphics g) {
        //m=new MissileView();
        //  m.render(g);

        g.drawImage(ship, p.getX(), p.getY(), null);
        //m.render(g);
    }
}
