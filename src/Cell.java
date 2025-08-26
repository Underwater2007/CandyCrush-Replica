
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 309954
 */
public class Cell {

    private static final Color[] COLORS = {Color.blue, Color.cyan, Color.green, Color.magenta, Color.red, Color.white, Color.yellow};
    public static final int SIZE = 50;
    private int color = -1;
    private boolean inChain = false;
    Random rand = new Random();

    public Cell() {
        color = rand.nextInt(COLORS.length);
    }

    public void draw(Graphics g, int x, int y) {
        //draw background
        if (inChain) {
            g.setColor(Color.darkGray);
        } else {
            g.setColor(Color.BLACK);

        }
        g.fillRect(x, y, SIZE, SIZE);
        //draw ball
        if (color > -1) {
            g.setColor(COLORS[color]);
            g.fillOval(x + 8, y + 8, SIZE - 16, SIZE - 16);
        }
    }

    public int getColor() {
        return color;
    }

    public void setEmpty() {
        color = -1;
        inChain = false;
    }

    public boolean isEmpty() {
        return (color == -1);
    }

    public boolean isInChain() {
        return inChain;
    }

    public void setInChain(boolean inChain) {
        this.inChain = inChain;
    }

    public void copy(Cell cell) {
        color = cell.getColor();
        inChain = false;
    }
}
