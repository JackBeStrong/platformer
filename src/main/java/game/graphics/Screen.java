package game.graphics;


import game.Game;
import game.control.Control;
import game.entity.Character;
import game.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;

public class Screen {

    private JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    public int[] pixels;
    private int[] pixelsToBeDrawn;

    // components
    private Background background;
    private List<Entity> entities;

    // control
    private Control control;

    public Screen() {
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        canvas = new Canvas();
        canvas.setSize(Game.WIDTH, Game.HEIGHT);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        init();
        start();
    }

    private void init() {
        canvas.createBufferStrategy(3);
        pixels = new int[Game.WIDTH * Game.HEIGHT];
        image = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixelsToBeDrawn = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        background = new Background(this);
        entities = new ArrayList<Entity>();
        entities.add(new Character(this, 200, 300));
        frame.addKeyListener(new Control());
    }

    private void start() {
        int fps = 0;
        int ups = 0;
        int counter = 0;
        int updateCounter = 0;
        double startTime = System.nanoTime();
        double upsStartTime = System.nanoTime();
        double delta = 0;
        double upsDelta = 0;
        while (true) {
            delta = System.nanoTime() - startTime;
            upsDelta = System.nanoTime() - upsStartTime;

            if (upsDelta >= 1000000000 / 60) {
                update();
                updateCounter ++;
                upsDelta = 0;
                upsStartTime = System.nanoTime();
            }
            render();
            counter ++;
            if (delta >= 1000000000) {
                delta = 0;
                fps = counter;
                counter = 0;
                ups = updateCounter;
                updateCounter = 0;
                frame.setTitle("Game | fps " + fps + " | ups: " + ups);
                startTime = System.nanoTime();
            }
        }
    }
    private void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    private void render() {
        background.render();
        for (Entity entity : entities) {
            entity.render();
        }
        for (int i = 0; i < Game.WIDTH * Game.HEIGHT; i++) {
            pixelsToBeDrawn[i] = pixels[i];
        }
        canvas.getBufferStrategy().getDrawGraphics().drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
        canvas.getBufferStrategy().getDrawGraphics().dispose();
        canvas.getBufferStrategy().show();
    }
}
