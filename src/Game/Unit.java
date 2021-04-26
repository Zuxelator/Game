package Game;

public class Unit {
    private String name;
    private int hitpoints;

    public Unit(String name) {
        hitpoints = 100;
        this.name = name;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void action(Unit unit, Team ourTeam, Team enemyTeam) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
