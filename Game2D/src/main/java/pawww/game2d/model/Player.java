/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

/**
 *
 * @author Lukasz
 */
public class Player extends Tank {

    public Player(int x, int y) {
        super(x, y);
    }

    public void goLeft() {
        x-=10;
        if (x < 0) {
            x=0;
        }
    }

    public void goRight() {
        x+=10;
        if(x>580){x=580;}
    }

}
