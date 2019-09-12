package game.entity;

import game.graphics.Screen;

public abstract class Entity {

    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    protected Screen screen;

    public Entity(Screen screen) {
        this.screen = screen;
    }

    public Entity(Screen screen, int x, int y) {
        this.x = x;
        this.y = y;
        this.screen = screen;
    }

    public Entity(Screen screen, int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.screen = screen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public abstract void render();

    public abstract void update();
}
