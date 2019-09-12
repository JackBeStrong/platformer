package game.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {

    public static boolean[] keyPressed = new boolean[525];

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
        System.out.println(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false;
    }
}
