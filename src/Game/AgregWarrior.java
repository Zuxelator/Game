package Game;

public class AgregWarrior extends Unit {
    private Warrior warrior;

    public AgregWarrior(String name, Warrior warrior) {
        super(name);
        this.warrior = warrior;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void attack(Unit unit) {
        warrior.attack(unit);
    }

    public void action(Unit unit, Team ourTeam, Team enemyTeam) {
        attack(unit);
    }
}
