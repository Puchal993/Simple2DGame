/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import pawww.game2d.Game;
import pawww.game2d.STATE;
import pawww.game2d.view.MenuView;

/**
 *
 * @author Daniel
 */
public class MenuMouseInput implements MouseListener{

    MenuView menu;
    Game game;
    
    public MenuMouseInput(MenuView menu,Game game){
        this.menu = menu;
        this.game = game;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        
        if(mx >= menu.getPlayButton().x && mx<=menu.getPlayButton().x + menu.getPlayButton().width){
            if(my >= menu.getPlayButton().y && my <= menu.getPlayButton().y+menu.getPlayButton().height){
                Game.State = STATE.PLAY;
                game.setIsTransition(true);
            }
        }
        
        if(mx >= menu.getScoreButton().x && mx<=menu.getScoreButton().x + menu.getScoreButton().width){
            if(my >= menu.getScoreButton().y && my <= menu.getScoreButton().y+menu.getScoreButton().height){
                Game.State = STATE.SCORE;
                game.setIsTransition(true);
            }
        }
        
        if(mx >= menu.getQuitButton().x && mx <=menu.getQuitButton().x+menu.getQuitButton().width){
            if(my >= menu.getQuitButton().y && my<= menu.getQuitButton().y+menu.getQuitButton().height){
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
