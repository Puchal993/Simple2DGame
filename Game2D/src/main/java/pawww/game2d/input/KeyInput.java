/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.input;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import pawww.game2d.Game;
import pawww.game2d.STATE;
import pawww.game2d.model.Missile;
import pawww.game2d.view.GameView;
import pawww.game2d.view.MissileView;

/**
 *
 * @author Lukasz
 */
public class KeyInput implements KeyListener {
    
    private GameView gv;
    private Game g;
    private MissileView m;

    public KeyInput(GameView v, Game g, MissileView m) {
        gv = v;
        this.g = g;
        this.m = m;
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == VK_LEFT) {
            gv.p.goLeft();
          //  System.out.println(gv.p.getX());
        } else if (ke.getKeyCode() == VK_RIGHT) {
            gv.p.goRight();
        } else if (ke.getKeyCode() == VK_ESCAPE) {
            Game.State = STATE.MENU;
            g.setIsTransition(true);
        } else if (ke.getKeyCode() == VK_ENTER) {
         //   System.out.println("enter");
            m.add(new Missile(gv.p.getX(), gv.p.getY() - 50));
            //m.render(g);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
