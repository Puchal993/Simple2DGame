/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d.view;

import java.awt.Graphics;
import java.util.LinkedList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import pawww.game2d.model.Enemy;
import pawww.game2d.model.IEnemy;
import pawww.game2d.model.IMissile;

/**
 *
 * @author Lukasz
 */
public class EnemyView {

    private String score = "0";

    public void addScore() throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = score += "+100";
        score = engine.eval(foo).toString();

    }

    private LinkedList<IEnemy> e = new LinkedList<IEnemy>();
    private LinkedList<IMissile> m = new LinkedList<IMissile>();
    private int x = 25, y = 0;
    private IEnemy en;
    private IMissile em;

    public EnemyView() {
        spawn();

    }

    private void spawn() {
        x = 25;
        y = 0;
        for (int i = 0; i < 6; i++) {
            e.add(new Enemy(x, y));
            x += 100;
        }
    }

    public void move() {
        for (int i = 0; i < e.size(); i++) {
            e.get(i).doMove();
        }
    }

    public void render(Graphics g) throws ScriptException {

        for (int i = 0; i < e.size(); i++) {
            en = e.get(i);
            en.render(g);

            if (en.isHit() == true) {
                e.remove(i);
            }

            if (e.size() == 0) {
                spawn();
            }
        }

    }

    public void del(IEnemy e) {
        this.e.remove(e);
    }

    public LinkedList<IEnemy> get() {
        return this.e;
    }
}
