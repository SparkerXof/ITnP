import java.util.ArrayList;

public class Game extends Application {
    protected int playerHP;
    protected int playerX;
    protected int playerY;
    protected ArrayList<GameItem> items = new ArrayList<GameItem>();

    public Game() {
        super();
        playerHP = 10;
        playerX = 0;
        playerY = 0;
    }

    public Game(double w, double h, String name, int hp) {
        super(w, hp, name);
        playerHP = hp;
        playerX = 0;
        playerY = 0;
    }

    public Game(double w, double h, String name, int hp, int x, int y) {
        super(w, hp, name);
        playerHP = hp;
        playerX = x;
        playerY = y;
    }

    public int getPlayerHP() {
        return playerHP;
    }
    public void setPlayerHP(int hp) {
        playerHP = hp;
    }

    public int getXPosition() {
        return playerX;
    }
    public void setXPosition(int x) {
        playerX = x;
    }

    public int getYPosition() {
        return playerY;
    }
    public void setYPosition(int y) {
        playerY = y;
    }

    public void addItem(GameItem item) {
        items.add(item);
    }
    public String grabItem() {
        String itemName;
        for (GameItem item : items) {
            if (item.x == playerX && item.y == playerY) {
                itemName = item.name;
                items.remove(item);
                return "You've got " + itemName;
            }
        }
        return "No items";
    }

    public void moveForward(boolean reverse) {
        playerY += (reverse ? -1 : 1);
    }
    public void moveRight(boolean reverse) {
        playerX += (reverse ? -1 : 1);
    }
}
