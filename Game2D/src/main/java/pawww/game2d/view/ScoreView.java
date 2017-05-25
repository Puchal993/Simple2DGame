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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import pawww.game2d.Game;

/**
 *
 * @author Daniel
 */
public class ScoreView {

    private Rectangle scoreBounds = new Rectangle(Game.WIDTH / 2 - 50, 100, 432, 300);

    private int spaceBetween = 10;
    private int scoreX = scoreBounds.x + scoreBounds.width - scoreBounds.width / 4;
    private int bottomRightCornerX = scoreBounds.x + scoreBounds.width;
    private int bottomRightCornerY = scoreBounds.y + scoreBounds.height;
    private int nextPageX = bottomRightCornerX - 5;
    private int nextPageY = bottomRightCornerY + 5;
    private int backPageX = bottomRightCornerX - 40;
    private int backPageY = nextPageY;
    private int pageButtonWidth = 5;
    private int pageButtonHeight = 10;
    private Rectangle menuButton = new Rectangle(scoreBounds.x, scoreBounds.y + scoreBounds.height + 5, 50, 25);

    Scanner scanner;
    String filename = "src/main/resources/scores.txt";
    String line = null;
    ArrayList<ArrayList<String>> items;
    int pageCount;
    int currentPage;

    public ScoreView() {

        try {

            scanner = new Scanner(new File(filename));
            scanner.useDelimiter(":");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        readScores();
        currentPage = 1;
    }
    
    public void init(){
        currentPage = 1;
    }

    public void readScores() {
        items = new ArrayList();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            items.add(new ArrayList(Arrays.asList(line.split(":"))));
        }

        pageCount = (items.size() + 9) / 10;
    }

    public void renderScores(int page, Graphics g) {

        for (int i = 0 + (10 * (page - 1)); i < 10 + (10 * (page - 1)); i++) {
            if (i < items.size()) {
                g.drawString(items.get(i).get(0), scoreBounds.x + 5, scoreBounds.y + 20 + (i - (10 * (page - 1))) * (spaceBetween + 20));
                g.drawString(items.get(i).get(1), scoreX, scoreBounds.y + 20 + (i - (10 * (page - 1))) * (spaceBetween + 20));
            }
        }

    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 20);

        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("Nickname", scoreBounds.x + 5, scoreBounds.y - 5);
        g.drawString("Score", scoreX, scoreBounds.y - 5);
        g2d.draw(scoreBounds);
        g2d.draw(menuButton);

        renderScores(currentPage, g);

        g2d.drawLine(bottomRightCornerX - 5, bottomRightCornerY + 5, bottomRightCornerX, bottomRightCornerY + 10);
        g2d.drawLine(bottomRightCornerX - 5, bottomRightCornerY + 15, bottomRightCornerX, bottomRightCornerY + 10);

        g2d.drawLine(bottomRightCornerX - 35, bottomRightCornerY + 5, bottomRightCornerX - 40, bottomRightCornerY + 10);
        g2d.drawLine(bottomRightCornerX - 35, bottomRightCornerY + 15, bottomRightCornerX - 40, bottomRightCornerY + 10);

        Font fnt1 = new Font("arial", Font.BOLD, 12);
        g.setFont(fnt1);

        g.drawString(currentPage + " / " + pageCount, bottomRightCornerX - 31, bottomRightCornerY + 15);
        g.drawString("BACK", menuButton.x+9, menuButton.y+menuButton.height-8);
    }

    public int getNextPageX() {
        return nextPageX;
    }

    public int getNextPageY() {
        return nextPageY;
    }

    public int getBackPageX() {
        return backPageX;
    }

    public int getBackPageY() {
        return backPageY;
    }

    public int getPageButtonWidth() {
        return pageButtonWidth;
    }

    public int getPageButtonHeight() {
        return pageButtonHeight;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }
    
    public Rectangle getMenuButton(){
        return menuButton;
    }

}
