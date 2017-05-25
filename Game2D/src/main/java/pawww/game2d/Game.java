/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawww.game2d;

import pawww.game2d.input.SpriteSheet;
import pawww.game2d.input.BufferedImageLoader;
import pawww.game2d.input.MenuMouseInput;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import javax.swing.JFrame;
import pawww.game2d.input.KeyInput;
import pawww.game2d.input.ScoreMouseInput;
import pawww.game2d.view.EnemyView;
import pawww.game2d.view.GameView;
import pawww.game2d.view.MenuView;
import pawww.game2d.view.MissileView;
import pawww.game2d.view.ScoreView;

/**
 *
 * @author Daniel
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "The Game";

    private boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;

    public static STATE State = STATE.MENU;

    private MenuView menu;
    private MenuMouseInput menuMouseInput;

    private GameView gameView;
    private KeyInput ki;

    private ScoreView scoreView;
    private ScoreMouseInput scoreMouseInput;

    private boolean isTransition = false;
    private MissileView m;
    private EnemyView enemy;

    public void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("/spriteSheet.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpriteSheet ss = new SpriteSheet(spriteSheet);

        menu = new MenuView();
        scoreView = new ScoreView();
        gameView = new GameView();
        menuMouseInput = new MenuMouseInput(menu, this);
        scoreMouseInput = new ScoreMouseInput(scoreView, this);
        enemy = new EnemyView();
        this.addMouseListener(menuMouseInput);
        m = new MissileView();
        ki = new KeyInput(gameView, this, m);
    }

    private synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;

        long timer = System.currentTimeMillis();

        while (running) {

            if (isTransition) {
                switch (State) {
                    case PLAY:
                        this.removeMouseListener(menuMouseInput);
                        this.addKeyListener(ki);

                        break;
                    case MENU:
                        this.removeMouseListener(scoreMouseInput);
                        this.addMouseListener(menuMouseInput);
                        break;
                    case SCORE:
                        scoreView.init();
                        this.removeMouseListener(menuMouseInput);
                        this.addMouseListener(scoreMouseInput);
                        break;
                    default:
                        break;
                }
                setIsTransition(false);
            }

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            try {
                render();
            } catch (ScriptException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ticks, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

        switch (State) {
            case PLAY:
                m.move(enemy.get());
                enemy.move();
                break;
            case MENU:
                break;
            case SCORE:
                break;
            default:
                break;
        }

    }

    private void render() throws ScriptException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //----------------------------
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        switch (State) {
            case PLAY:
                gameView.render(g);

                enemy.render(g);
                m.render(g);
                break;
            case MENU:
                menu.render(g);
                break;
            case SCORE:
                scoreView.render(g);
                break;
            default:
                break;
        }

        //----------------------------
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    public boolean isIsTransition() {
        return isTransition;
    }

    public void setIsTransition(boolean isTransition) {
        this.isTransition = isTransition;
    }

}
