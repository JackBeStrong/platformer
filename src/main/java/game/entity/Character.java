package game.entity;

import game.Game;
import game.control.Control;
import game.graphics.Screen;

import java.awt.*;

public class Character extends Entity {

    private int speed = 5;
    private int size = 5;

    public Character(Screen screen) {
        super(screen);
    }

    public Character(Screen screen, int x, int y) {
        super(screen, x, y);
    }

    public void render() {
        for (int column = x; column < x + size; column++) {
            for (int row = y; row < y + size; row++) {
                screen.pixels[row * Game.WIDTH + column] = Color.BLUE.getRGB();
            }
        }
    }

    public void update() {
        // set left or right
        if (Control.keyPressed[37] || Control.keyPressed[39]) {
            if (Control.keyPressed[37]) {
                vx = -speed;
            }
            else {
                vx = speed;
            }
        }
        else {
            vx = 0;
        }

        // set up or down
        if (Control.keyPressed[38] || Control.keyPressed[40]) {
            if (Control.keyPressed[38]) {
                vy = -speed;
            }
            else {
                vy = speed;
            }
        }
        else {
            vy = 0;
        }

        // move
        x += vx;
        y += vy;
    }
}
