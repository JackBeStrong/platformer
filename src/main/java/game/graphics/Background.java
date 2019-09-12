package game.graphics;

import game.Game;

import java.awt.*;

public class Background {

    // draw a rectangle as a platform
    private int height = 20;
    private int location = 400;

    private Screen screen;

    public Background(Screen screen) {
        this.screen = screen;
    }

    public void render() {
        for (int i = 0; i < screen.pixels.length; i++) {
            screen.pixels[i] = 0xFFFFFF;
        }

        // draw a platform
        // for the 5h column and 2nd row
        // pixels[2 * width + 5]
        for (int column = 0; column < Game.WIDTH; column++) {
            for (int row = location; row < location + height; row++) {
                screen.pixels[row * Game.WIDTH + column] = Color.RED.getRGB();
            }
        }
    }
}
