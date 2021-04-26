package Game;

public class AgregArcher extends Unit{
    Archer archer;

    public AgregArcher(String name, Archer archer) {
        super(name);
        this.archer = archer;
    }

    public Archer getArcher() {
        return archer;
    }

    public void shoot(Unit unit) {
        archer.shoot(unit);
    }

    public void archerAttack(Unit unit) {
        archer.archerAttack(unit);
    }

    public void action(Unit unit, Team ourTeam, Team enemyTeam) {
        int random = (int)(Math.random() * 2);
        if(random == 0) {
            shoot(unit);
        } else {
            archerAttack(unit);
        }
    }
}
