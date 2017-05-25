/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.model;

import java.util.LinkedList;

/**
 *
 * @author Lukasz
 */
public class Hit {

    public static boolean isHit(IMissile mis, LinkedList<IEnemy> enemy) {
        for (int i = 0; i < enemy.size(); i++) {
            if (mis.getBounds().intersects(enemy.get(i).getBounds())) {
                enemy.get(i).setHit();
                return true;
            }
        }
        return false;
    }
}
