/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import pawww.game2d.Game;
import pawww.game2d.model.Enemy;
import pawww.game2d.model.IEnemy;
import pawww.game2d.model.IMissile;
import pawww.game2d.model.Missile;

/**
 *
 * @author Lukasz
 */
public class MissileView {

    private LinkedList<IMissile> m = new LinkedList<IMissile>();
//private LinkedList<Enemy> e;
    IMissile mis;

 

    public void move(LinkedList<IEnemy> e) {
        for (int i = 0; i < m.size(); i++) {

            //  System.out.println("TAK");
            mis = m.get(i);
            mis.doMove(e);

        }
        //  System.out.println("FINALLE");
    }

    public void render(Graphics g) {
        for (int i = 0; i < m.size(); i++) {
            mis = m.get(i);
            mis.render(g);
            if (mis.getY() == -200) {
                del(m.get(i));
            }
            
            
        }
    }

    public void add(IMissile m) {
        this.m.add(m);
        //   System.out.println(this.m.size());
    }

    public void del(IMissile m) {
        this.m.remove(m);
    }
}
