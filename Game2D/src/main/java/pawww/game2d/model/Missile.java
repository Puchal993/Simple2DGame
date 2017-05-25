/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import pawww.game2d.Game;
import pawww.game2d.view.EnemyView;

/**
 *
 * @author Lukasz
 */
public class Missile extends Tank implements IMissile {

    Image image = new ImageIcon("mis.jpg").getImage();

    public Missile(int x, int y) {
        super(x, y);
    }

    @Override
    public void doMove(LinkedList<IEnemy> e) {
        // if (y > 0) {
        y -= 10;
        if (Hit.isHit(this, e)) {
            
          
        }
        //  System.out.println("DO");
        //  }
    }

    public void render(Graphics g) {

        //  mis = m.get(i);
        g.drawImage(image, x + 22, y, null);

        // mis.doMove();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 27);
    }

  

  
}
