/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import pawww.game2d.Game;

/**
 *
 * @author Daniel
 */
public class MenuView {

    private Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
    private Rectangle scoreButton = new Rectangle(Game.WIDTH / 2 + 110, 250, 120, 50);
    private Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 350, 100, 50);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("THE GAME", Game.WIDTH / 2+40, 100);
        
        Font fnt1 = new Font("arial",Font.BOLD,30);
        g.setFont(fnt1);
        g.drawString("PLAY", playButton.x+12, playButton.y+playButton.height-15);
        g.drawString("SCORE", scoreButton.x+7, scoreButton.y+scoreButton.height-15);
        g.drawString("QUIT", quitButton.x+12,quitButton.y+quitButton.height-15);
        
        g2d.draw(playButton);
        g2d.draw(scoreButton);
        g2d.draw(quitButton);
    }

    public Rectangle getPlayButton() {
        return playButton;
    }

    public Rectangle getScoreButton() {
        return scoreButton;
    }

    public Rectangle getQuitButton() {
        return quitButton;
    }

    
    
}
