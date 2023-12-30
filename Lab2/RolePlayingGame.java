public class RolePlayingGame extends Game {
    private int playerMP;
    private int manaPotions = 0;
    private int healthPotions = 0;

    public RolePlayingGame() {
        super();
        playerMP = 10;
    }

    public RolePlayingGame(double w, double h, String name, int hp, int mp) {
        super(w, h, name, hp);
        playerMP = mp;
    }
    public RolePlayingGame(double w, double h, String name, int hp, int mp, int x, int y) {
        super(w, h, name, hp, x, y);
        playerMP = mp;
    }

    public int getPlayerMP() {
        return playerMP;
    }
    public void setPlayerMP(int mp) {
        playerMP = mp;
    }

    public void heal() {
        if (healthPotions > 0) {
            playerHP += 5;
            healthPotions--;
        }
        else {
            System.out.println("No health potions");
        }
    }
    public void restoreMana() {
        if (manaPotions > 0) {
            playerMP += 10;
            manaPotions--;
        }
        else {
            System.out.println("No mana potions");
        }
    }

    public void makeHealthPotions() {
        if (playerMP >= 5) {
            healthPotions++;
            playerMP -= 5;
        }
        else {
            System.out.println("No mana");
        }
    }

    @Override
    public String grabItem() {
        String itemName;
        for (GameItem item : items) {
            if (item.x == playerX && item.y == playerY) {
                itemName = item.name;
                if (itemName.equals("Health Potion")) {
                    healthPotions++;
                }
                else if (itemName.equals("Mana Potion")) {
                    manaPotions++;
                }
                return "You've got " + itemName;
            }
        }
        return "No items";
    }
}
