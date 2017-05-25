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
import pawww.game2d.view.ScoreView;

/**
 *
 * @author Daniel
 */
public class ScoreMouseInput implements MouseListener {

    private ScoreView sv;
    private Game game;

    public ScoreMouseInput(ScoreView sv,Game game) {
        this.sv = sv;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();

        if (mx >= sv.getBackPageX() && mx <= sv.getBackPageX() + sv.getPageButtonWidth()) {
            if (my >= sv.getBackPageY() && my <= sv.getBackPageY() + sv.getPageButtonHeight()) {
                if (sv.getCurrentPage() > 1) {
                    sv.setCurrentPage(sv.getCurrentPage()-1);
                }
            }
        }

        if (mx >= sv.getNextPageX() && mx <= sv.getNextPageX() + sv.getPageButtonWidth()) {
            if (my >= sv.getNextPageY() && my <= sv.getNextPageY() + sv.getPageButtonHeight()) {
                if (sv.getCurrentPage() < sv.getPageCount()) {
                    sv.setCurrentPage(sv.getCurrentPage()+1);
                }
            }
        }
        
        if (mx >= sv.getMenuButton().x && mx <= sv.getMenuButton().x + sv.getMenuButton().width) {
            if (my >= sv.getMenuButton().y && my <= sv.getMenuButton().y + sv.getMenuButton().height) {
                game.setIsTransition(true);
                Game.State = STATE.MENU;
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
